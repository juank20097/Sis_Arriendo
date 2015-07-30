/***********************************************************************
 * Module:  ArrContratoDet.java
 * Author:  jestevez
 * Purpose: Defines the Class ArrContratoDet
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid ea091c16-1e8f-477b-8755-14092db8eca4 */
public class ArrContratoDet {
   /** @pdOid 0b9fc25a-4805-478b-80b9-93fd5117addb */
   private Integer detId;
   /** @pdOid f5b57b0c-701e-4ec4-b121-5750f04b0f2b */
   private String detObservacion;
   /** @pdOid 8df9fec3-5a7a-4885-b0d8-7a7a1ad171fe */
   private Float detCosto;
   /** @pdOid 130743f5-3ae3-405f-891b-f5000f771b56 */
   private char detEstado = 1;
   
   /** @pdOid 7043e8c9-7c34-4c29-b8a0-b417f2d8feeb */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GenSitios assc=association2 mult=1..1 side=A */
   public GenSitios sit;
   /** @pdRoleInfo migr=no name=ArrContratoCab assc=association3 mult=1..1 side=A */
   public ArrContratoCab con_cab;
   
   /** @pdOid 269aff93-3eb8-4dda-bf79-b41953985d98 */
   public ArrContratoDet() {
      // TODO: implement
   }
   
   /** @pdOid 0e62b5dd-b2ca-4880-952f-206be44b7630 */
   public Integer getDetId() {
      return detId;
   }
   
   /** @param newDetId
    * @pdOid a1381c37-40ac-48af-a1ad-94be4d1b698f */
   public void setDetId(Integer newDetId) {
      detId = newDetId;
   }
   
   /** @pdOid 56a840bf-9cb6-4803-9726-877a2c122ed8 */
   public String getDetObservacion() {
      return detObservacion;
   }
   
   /** @param newDetObservacion
    * @pdOid b8defaf2-c318-453e-8e98-ff27094b9f6e */
   public void setDetObservacion(String newDetObservacion) {
      detObservacion = newDetObservacion;
   }
   
   /** @pdOid a7c8b6cb-3b47-47e3-929c-948079480d8c */
   public Float getDetCosto() {
      return detCosto;
   }
   
   /** @param newDetCosto
    * @pdOid 79c9c133-d51e-4a22-821f-58e99a2fdc20 */
   public void setDetCosto(Float newDetCosto) {
      detCosto = newDetCosto;
   }
   
   
   /** @pdGenerated default parent getter */
   public GenSitios getSit() {
      return sit;
   }
   
   /** @pdGenerated default parent setter
     * @param newGenSitios */
   public void setSit(GenSitios newGenSitios) {
      if (this.sit == null || !this.sit.equals(newGenSitios))
      {
         if (this.sit != null)
         {
            GenSitios oldGenSitios = this.sit;
            this.sit = null;
            oldGenSitios.removeCon_det(this);
         }
         if (newGenSitios != null)
         {
            this.sit = newGenSitios;
            this.sit.addCon_det(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public ArrContratoCab getCon_cab() {
      return con_cab;
   }
   
   /** @pdGenerated default parent setter
     * @param newArrContratoCab */
   public void setCon_cab(ArrContratoCab newArrContratoCab) {
      if (this.con_cab == null || !this.con_cab.equals(newArrContratoCab))
      {
         if (this.con_cab != null)
         {
            ArrContratoCab oldArrContratoCab = this.con_cab;
            this.con_cab = null;
            oldArrContratoCab.removeCon_det(this);
         }
         if (newArrContratoCab != null)
         {
            this.con_cab = newArrContratoCab;
            this.con_cab.addCon_det(this);
         }
      }
   }

}