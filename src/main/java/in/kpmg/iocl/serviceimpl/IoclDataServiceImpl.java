package in.kpmg.iocl.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import in.kpmg.iocl.entity.ExchangeEntity;
import in.kpmg.iocl.repo.ExchangeRepo;
import in.kpmg.iocl.api.ExchangeRateRequest;
import in.kpmg.iocl.api.ExchangeRateResponse;
import in.kpmg.iocl.api.AllExchange;

@Service
public class IoclDataServiceImpl {
	private static final Logger logger = LogManager.getLogger(IoclDataServiceImpl.class);

	@Autowired
	private ExchangeRepo exchangeRepo;


	public ExchangeRateResponse fetchExchangeRate(ExchangeRateRequest req) {
		String from_currency = req.getFromCurrency();
		String to_currency = req.getToCurrency();
		String exchange_type = req.getExchangeType();
		String effective_date = req.getEffectiveDate();

		ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();

		List<AllExchange> fetchedList = new ArrayList<>();

		if (from_currency!= null && from_currency.length() > 0 &&
				to_currency != null && to_currency.length() > 0 &&
				exchange_type !=null && exchange_type.length() > 0 &&
				effective_date != null && effective_date.length() > 0) {
			try {
				List<ExchangeEntity> fetchData = exchangeRepo
						.fetchExchangeData(from_currency, to_currency, exchange_type, effective_date);

				for (ExchangeEntity data : fetchData) {
					AllExchange allExchange = new AllExchange();
				    allExchange.setEffectiveDate(effective_date);
					allExchange.setExchangeType(exchange_type);
					allExchange.setFromCurrencyRatio(data.getFfact());
					allExchange.setToCurrencyRatio(data.getTfact());
					allExchange.setFromCurrency(data.getFcurr());
					allExchange.setToCurrency(data.getTcurr());
					allExchange.setExchangeRate(data.getUkurs());
					fetchedList.add(allExchange);
				}

				if (fetchedList.size() > 0) {
					exchangeRateResponse.setIsSuccess(true);
					logger.info("Data is fetched successfully");
					exchangeRateResponse.getExchange().addAll(fetchedList);
				}
				else{
					exchangeRateResponse.setIsSuccess(true);
					logger.info("No data present for the provided request");
				}
			} catch (Exception e) {
				exchangeRateResponse.setIsSuccess(false);
				logger.info("Exception occured :: " + e.getMessage());
				e.printStackTrace();
			}
		}
		else {
			exchangeRateResponse.setIsSuccess(false);
			logger.info("Mandatory request is empty");
		}
		return exchangeRateResponse;
	}

};