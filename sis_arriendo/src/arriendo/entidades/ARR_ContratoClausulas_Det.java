/***********************************************************************
 * Module:  ARR_ContratoClausulas_Det.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_ContratoClausulas_Det
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 4e90943d-7d63-4796-b308-a2520cabe91e */
public class ARR_ContratoClausulas_Det {
   /** @pdOid 3b6a3e45-4aea-440f-a76b-77c4a3b9a5d9 */
   private Integer ccd_id;
   /** @pdOid 7a077853-6d02-4835-95db-f46b25cda627 */
   private Integer ccd_numero;
   /** @pdOid e10ccb85-1604-40a3-b9bf-7b7eb0d232ae */
   private short ccd_clausula;
   /** @pdOid 67a9a8b0-d256-47e6-99fe-47cc22fa0797 */
   private char ccd_estado;
   
   /** @pdOid 6de8d1d3-e1b7-4ca3-8f71-91e089279a91 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Contrato_Cab assc=association13 mult=1..1 side=A */
   public ARR_Contrato_Cab con_cab;
   
   /** @pdOid 5f4cf577-19ab-4ac3-9071-94d33d418a11 */
   public ARR_ContratoClausulas_Det() {
      // TODO: implement
   }
   
   /** @pdOid f6dbdc05-1f08-4170-8293-29d1be182f74 */
   public Integer getCcd_id() {
      return ccd_id;
   }
   
   /** @param newCcd_id
    * @pdOid b4de8f6f-2783-4e2c-815b-0fbbdc306d36 */
   public void setCcd_id(Integer newCcd_id) {
      ccd_id = newCcd_id;
   }
   
   /** @pdOid 417dc014-ca73-481b-82a0-cc577ad936cc */
   public Integer getCcd_numero() {
      return ccd_numero;
   }
   
   /** @param newCcd_numero
    * @pdOid 0a1434b3-4c1a-488b-adf7-26e155da9e37 */
   public void setCcd_numero(Integer newCcd_numero) {
      ccd_numero = newCcd_numero;
   }
   
   /** @pdOid 6fb01929-6f5f-4c0c-9f42-55075533c5d1 */
   public short getCcd_clausula() {
      return ccd_clausula;
   }
   
   /** @param newCcd_clausula
    * @pdOid 1389701e-01f2-40c8-a804-6cadf8ccabd4 */
   public void setCcd_clausula(short newCcd_clausula) {
      ccd_clausula = newCcd_clausula;
   }
   
   /** @pdOid af18991c-bc88-44bd-89c5-a6d8377e9f20 */
   public char getCcd_estado() {
      return ccd_estado;
   }
   
   /** @param newCcd_estado
    * @pdOid efecb6e5-03b4-4969-8b21-6a1c96dec416 */
   public void setCcd_estado(char newCcd_estado) {
      ccd_estado = newCcd_estado;
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
            oldARR_Contrato_Cab.removeCon_cla_d(this);
         }
         if (newARR_Contrato_Cab != null)
         {
            this.con_cab = newARR_Contrato_Cab;
            this.con_cab.addCon_cla_d(this);
         }
      }
   }

}