/***********************************************************************
 * Module:  ARR_Contrato_Det.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_Contrato_Det
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid ea091c16-1e8f-477b-8755-14092db8eca4 */
public class ARR_Contrato_Det {
   /** @pdOid 0b9fc25a-4805-478b-80b9-93fd5117addb */
   private Integer det_id;
   /** @pdOid f5b57b0c-701e-4ec4-b121-5750f04b0f2b */
   private String det_observacion;
   /** @pdOid 8df9fec3-5a7a-4885-b0d8-7a7a1ad171fe */
   private Float det_costo;
   /** @pdOid 130743f5-3ae3-405f-891b-f5000f771b56 */
   private char det_estado = 1;
   
   /** @pdOid 7043e8c9-7c34-4c29-b8a0-b417f2d8feeb */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Sitios assc=association2 mult=1..1 side=A */
   public GEN_Sitios sit;
   /** @pdRoleInfo migr=no name=ARR_Contrato_Cab assc=association3 mult=1..1 side=A */
   public ARR_Contrato_Cab con_cab;
   
   /** @pdOid 269aff93-3eb8-4dda-bf79-b41953985d98 */
   public ARR_Contrato_Det() {
      // TODO: implement
   }
   
   /** @pdOid 0e62b5dd-b2ca-4880-952f-206be44b7630 */
   public Integer getDet_id() {
      return det_id;
   }
   
   /** @param newDet_id
    * @pdOid a1381c37-40ac-48af-a1ad-94be4d1b698f */
   public void setDet_id(Integer newDet_id) {
      det_id = newDet_id;
   }
   
   /** @pdOid 56a840bf-9cb6-4803-9726-877a2c122ed8 */
   public String getDet_observacion() {
      return det_observacion;
   }
   
   /** @param newDet_observacion
    * @pdOid b8defaf2-c318-453e-8e98-ff27094b9f6e */
   public void setDet_observacion(String newDet_observacion) {
      det_observacion = newDet_observacion;
   }
   
   /** @pdOid a7c8b6cb-3b47-47e3-929c-948079480d8c */
   public Float getDet_costo() {
      return det_costo;
   }
   
   /** @param newDet_costo
    * @pdOid 79c9c133-d51e-4a22-821f-58e99a2fdc20 */
   public void setDet_costo(Float newDet_costo) {
      det_costo = newDet_costo;
   }
   
   /** @pdOid 37d3a117-0508-4059-8594-a0642940233d */
   public char getDet_estado() {
      return det_estado;
   }
   
   /** @param newDet_estado
    * @pdOid e1406a0f-f569-456f-93d0-a449ca90e342 */
   public void setDet_estado(char newDet_estado) {
      det_estado = newDet_estado;
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
            oldGEN_Sitios.removeCon_det(this);
         }
         if (newGEN_Sitios != null)
         {
            this.sit = newGEN_Sitios;
            this.sit.addCon_det(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public ARR_Contrato_Cab getCon_cab() {
      return con_cab;
   }
   
   /** @pdGenerated default parent setter
     * @param newARR_Contrato_Cab */
   public void setCon_cab(ARR_Contrato_Cab newARR_Contrato_Cab) {
      if (this.con_cab == null || !this.con_cab.equals(newARR_Contrato_Cab))
      {
         if (this.con_cab != null)
         {
            ARR_Contrato_Cab oldARR_Contrato_Cab = this.con_cab;
            this.con_cab = null;
            oldARR_Contrato_Cab.removeCon_det(this);
         }
         if (newARR_Contrato_Cab != null)
         {
            this.con_cab = newARR_Contrato_Cab;
            this.con_cab.addCon_det(this);
         }
      }
   }

}