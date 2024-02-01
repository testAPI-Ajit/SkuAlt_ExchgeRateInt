package in.kpmg.iocl.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.kpmg.iocl.dto.SkuAltDto;
import in.kpmg.iocl.entity.Mat_MaraModel;
import in.kpmg.iocl.entity.SKUModel;
import in.kpmg.iocl.repo.SKURepository;
import in.kpmg.iocl.skuapi.SkuAltConversion;
import in.kpmg.iocl.skuapi.SkuAltConversionRequest;
import in.kpmg.iocl.skuapi.SkuAltConversionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

@Service
public class SKUService {
    private static final Logger logger = LogManager.getLogger(SKUService.class);
    @Autowired
    SKURepository skuRepository;

    public SkuAltConversionResponse getSkuresponse(@RequestBody SkuAltConversionRequest req) {

        String materialNo = req.getMaterialNo();
        SkuAltConversionResponse skuAltConversionResponse = new SkuAltConversionResponse();
        skuAltConversionResponse.setIsSuccess(false);


        if(materialNo!=null)
        {
            List<SKUModel> skuDetails = skuRepository.getSKUData(materialNo);
            skuAltConversionResponse.setIsSuccess(true);
            try {
                for(SKUModel skuData:skuDetails) {
                    SkuAltConversion sku_altConversion = new SkuAltConversion();

                    sku_altConversion.setMaterialNo(skuData.getMatnr());
                    logger.info("Material No from SKU part: "+ skuData.getMatnr());
                    sku_altConversion.setBaseUnitOfMeasure(skuData.getMeinh());
                    sku_altConversion.setUnitOfMeasureDisplay(skuData.getMeins());
                    logger.info("Umren Detail " + skuData.getUmren());
                    sku_altConversion.setNumeratorConversion(skuData.getUmren());
                    logger.info("Umrez Detail: " +skuData.getUmrez());
                    sku_altConversion.setDenominatorConversion(skuData.getUmrez());

                    logger.info("Calling Materials Description ");
                    sku_altConversion.setMaterialDescription(skuRepository.getMat_Description(skuData.getMatnr()).get(0));

                    skuAltConversionResponse.getSkuAltConversion().add(sku_altConversion);
                    logger.info("Data successfully updated based on material Number");

                }
                /*ObjectMapper om = new ObjectMapper();
                logger.info("Material Descption record "+ om.writeValueAsString(skuAltConversionResponse.getSkuAltConversion()));*/
            }catch(Exception ex){
                skuAltConversionResponse.setIsSuccess(false);
               logger.error("Unable to fetch data", ex);
                ex.printStackTrace();
            }
        }return skuAltConversionResponse;
    }
}
