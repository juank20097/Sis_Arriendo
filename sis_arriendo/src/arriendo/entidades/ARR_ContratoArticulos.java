/***********************************************************************
 * Module:  ARR_ContratoArticulos.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_ContratoArticulos
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid d556c807-f34f-4d0e-a502-c53cae046dbf */
public class ARR_ContratoArticulos {
   /** @pdOid 0d28f12c-f8a3-4171-a68f-920ef700f1e7 */
   private Integer ca_id;
   /** @pdOid 7679dbb0-b601-4a53-8eb7-8f7444d1c0e6 */
   private Integer art_id;
   
   /** @pdOid 98e3d13f-e8e8-4066-ad9f-4bb4640131f1 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Contratos_Det assc=association14 mult=1..1 */
   public ARR_Contratos_Det con_det;
   
   /** @pdOid f50695d7-7944-46e1-9232-381f38e430a1 */
   public ARR_ContratoArticulos() {
      // TODO: implement
   }
   
   /** @pdOid a66fc061-8080-47f2-b2a4-ebc7d6bccada */
   public Integer getCa_id() {
      return ca_id;
   }
   
   /** @param newCa_id
    * @pdOid 5a40c601-15f5-4e18-9e41-7a4951af8c1a */
   public void setCa_id(Integer newCa_id) {
      ca_id = newCa_id;
   }
   
   /** @pdOid 49ca4344-c115-47c5-b430-a8e44b8aa790 */
   public Integer getArt_id() {
      return art_id;
   }
   
   /** @param newArt_id
    * @pdOid f611fdcd-5cbe-47cf-8f79-1e0e26d8a85a */
   public void setArt_id(Integer newArt_id) {
      art_id = newArt_id;
   }
   
   
   /** @pdGenerated default parent getter */
   public ARR_Contratos_Det getCon_det() {
      return con_det;
   }
   
   /** @pdGenerated default parent setter
     * @param newARR_Contratos_Det */
   public void setCon_det(ARR_Contratos_Det newARR_Contratos_Det) {
      if (this.con_det == null || !this.con_det.equals(newARR_Contratos_Det))
      {
         /*if (this.con_det != null)
         {
            ARR_Contratos_Det oldARR_Contratos_Det = this.con_det;
            this.con_det = null;
            oldARR_Contratos_Det.removeCon_art(this);
         }*/
         if (newARR_Contratos_Det != null)
         {
            this.con_det = newARR_Contratos_Det;
            this.con_det.addCon_art(this);
         }
      }
   }

}