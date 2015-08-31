/***********************************************************************
 * Module:  ARR_SitiosArticulos.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_SitiosArticulos
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 16df1f60-af1d-4f30-b70b-002f45e10915 */
public class ARR_SitiosArticulos {
   /** @pdOid 119629aa-6af4-40f3-814b-a97efd031bb8 */
   private Integer saId;
   /** @pdOid 6a32a0f9-0e53-478c-921b-32e3d81be803 */
   private Integer art_id;
   
   /** @pdOid 58dc61de-e400-4eb5-97e3-a5a2526a6aa3 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Sitios assc=association18 mult=1..1 */
   public GEN_Sitios sit;
   
   /** @pdOid 0eceb3c6-db66-41f2-8667-8120f7c2bf48 */
   public ARR_SitiosArticulos() {
      // TODO: implement
   }
   
   /** @pdOid c1962909-5731-4307-b313-1cc09157292d */
   public Integer getSaId() {
      return saId;
   }
   
   /** @param newSaId
    * @pdOid 1a8bee5d-d7e1-4e02-a5af-6df7501f1d84 */
   public void setSaId(Integer newSaId) {
      saId = newSaId;
   }
   
   /** @pdOid 364bb7ca-128a-431d-88eb-787eea3529ef */
   public Integer getArt_id() {
      return art_id;
   }
   
   /** @param newArt_id
    * @pdOid 64fc5d44-3044-4248-9848-e8a8c4de21b9 */
   public void setArt_id(Integer newArt_id) {
      art_id = newArt_id;
   }
   
   
   /** @pdGenerated default parent getter */
   public GEN_Sitios getSit() {
      return sit;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_Sitios */
   public void setSit(GEN_Sitios newGEN_Sitios) {
      if (this.sit == null || !this.sit.equals(newGEN_Sitios))
      {
         if (this.sit != null)
         {
            GEN_Sitios oldGEN_Sitios = this.sit;
            this.sit = null;
            oldGEN_Sitios.removeSa(this);
         }
         if (newGEN_Sitios != null)
         {
            this.sit = newGEN_Sitios;
            this.sit.addSa(this);
         }
      }
   }

}