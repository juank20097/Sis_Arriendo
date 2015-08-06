/***********************************************************************
 * Module:  GEN_ContratoPlantillaClausulas_Det.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_ContratoPlantillaClausulas_Det
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid bef3c3e6-75a6-4623-a3c7-24fc28a01058 */
public class GEN_ContratoPlantillaClausulas_Det {
   /** @pdOid 7aa23910-6ce2-4db0-ad6d-5cd05d31bdd1 */
   private Integer cpd_id;
   /** @pdOid 86a6c2d9-2d57-4b9a-8a5d-d5e529412d22 */
   private Integer cpd_numero;
   /** @pdOid 5ce240c5-7fea-46e7-9921-175e909486b5 */
   private String cpp_clausula;
   /** @pdOid 27c773ea-98c5-4f65-a450-1b5923cde6ae */
   private Integer cpd_estado;
   
   /** @pdOid ff01b356-3ed2-4416-876c-215124ccc73a */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_ContratoPlantilla_Cab assc=association12 mult=1..1 */
   public GEN_ContratoPlantilla_Cab con_p_c;
   
   /** @pdOid 0f120f7c-31cd-4d08-93b6-846ac6b0d5f4 */
   public GEN_ContratoPlantillaClausulas_Det() {
      // TODO: implement
   }
   
   /** @pdOid 5b7e9c6e-bc91-4f46-be95-13cc9e5157c8 */
   public Integer getCpd_id() {
      return cpd_id;
   }
   
   /** @param newCpd_id
    * @pdOid d7311069-f20f-4c7f-8ac3-344ca047f417 */
   public void setCpd_id(Integer newCpd_id) {
      cpd_id = newCpd_id;
   }
   
   /** @pdOid c191e44d-aa6b-463b-a247-d3902cabd812 */
   public Integer getCpd_numero() {
      return cpd_numero;
   }
   
   /** @param newCpd_numero
    * @pdOid 9875ca3f-857d-4762-8364-161a559af9e2 */
   public void setCpd_numero(Integer newCpd_numero) {
      cpd_numero = newCpd_numero;
   }
   
   /** @pdOid 18be686e-422b-41ed-9333-a84baa6ab871 */
   public String getCpp_clausula() {
      return cpp_clausula;
   }
   
   /** @param newCpp_clausula
    * @pdOid 84002470-2412-4ccf-934a-e976e794d4b6 */
   public void setCpp_clausula(String newCpp_clausula) {
      cpp_clausula = newCpp_clausula;
   }
   
   /** @pdOid 4880885a-28f7-4877-a72a-12cb8959208e */
   public Integer getCpd_estado() {
      return cpd_estado;
   }
   
   /** @param newCpd_estado
    * @pdOid e7872d81-5b60-4c1b-ba5f-bfb0933d0266 */
   public void setCpd_estado(Integer newCpd_estado) {
      cpd_estado = newCpd_estado;
   }
   
   
   /** @pdGenerated default parent getter */
   public GEN_ContratoPlantilla_Cab getCon_p_c() {
      return con_p_c;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_ContratoPlantilla_Cab */
   public void setCon_p_c(GEN_ContratoPlantilla_Cab newGEN_ContratoPlantilla_Cab) {
      if (this.con_p_c == null || !this.con_p_c.equals(newGEN_ContratoPlantilla_Cab))
      {
         if (this.con_p_c != null)
         {
            GEN_ContratoPlantilla_Cab oldGEN_ContratoPlantilla_Cab = this.con_p_c;
            this.con_p_c = null;
            oldGEN_ContratoPlantilla_Cab.removeCon_p_d(this);
         }
         if (newGEN_ContratoPlantilla_Cab != null)
         {
            this.con_p_c = newGEN_ContratoPlantilla_Cab;
            this.con_p_c.addCon_p_d(this);
         }
      }
   }

}