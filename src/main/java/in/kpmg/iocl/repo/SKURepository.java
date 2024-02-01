package in.kpmg.iocl.repo;

import in.kpmg.iocl.dto.SkuAltDto;
import in.kpmg.iocl.entity.Mat_MaraModel;
import in.kpmg.iocl.entity.SKUModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.UniqueConstraint;
import java.util.List;

@Repository
public interface SKURepository extends JpaRepository<SKUModel,Long> {

    @Query(value= "Select sac from SKUModel sac where sac.matnr= :materialNo")
   // @Query(value= "Select sac.matnr,sac.umren,sac.meinh,sac.seprtr,sac.umrez, sac.meins" +
       //     " from SKUModel sac where sac.matnr= :materialNo")

    public List<SKUModel> getSKUData(
            @Param("materialNo") String materialNo
    );


    @Query(value= "Select mar.maktx from Mat_MaraModel mar where mar.matnr= :materialNo")
    public List<String> getMat_Description(
           @Param("materialNo") String materialNo
    );
}








