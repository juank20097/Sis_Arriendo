/***********************************************************************
 * Module:  ArrItems.java
 * Author:  jestevez
 * Purpose: Defines the Class ArrItems
 ***********************************************************************/

package arriendo.Entidades;

import java.util.*;

/** @pdOid 3ee7c526-195b-4a31-88be-15e664ae93b1 */
public class ArrItems {
   /** @pdOid 8f85d3e2-3e4e-49a2-b7f0-9e7b595fd853 */
   private Integer iteId;
   /** @pdOid 0ad2010d-aab0-471e-9e38-7569a70b2b35 */
   private String iteDescripcion;
   
   /** @pdOid 50b1f8b5-e5b4-454e-840c-b93813339a49 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ArrClausulas assc=association6 mult=1..1 side=A */
   public ArrClausulas cla;
   
   /** @pdOid ed00f2a3-6882-4c74-b6fd-bd9459040474 */
   public ArrItems() {
      // TODO: implement
   }
   
   /** @pdOid 85c3e9ec-6e68-4ce7-8484-fb6a079cd463 */
   public Integer getIteId() {
      return iteId;
   }
   
   /** @param newIteId
    * @pdOid 9a09602a-00a7-4958-bbc5-89b0fe92bda8 */
   public void setIteId(Integer newIteId) {
      iteId = newIteId;
   }
   
   /** @pdOid 0e41ae3e-90d4-44fd-9319-4f12dcb91017 */
   public String getIteDescripcion() {
      return iteDescripcion;
   }
   
   /** @param newIteDescripcion
    * @pdOid 58537e6c-74b4-4463-86d0-07841b2f72ce */
   public void setIteDescripcion(String newIteDescripcion) {
      iteDescripcion = newIteDescripcion;
   }
   
   
   /** @pdGenerated default parent getter */
   public ArrClausulas getCla() {
      return cla;
   }
   
   /** @pdGenerated default parent setter
     * @param newArrClausulas */
   public void setCla(ArrClausulas newArrClausulas) {
      if (this.cla == null || !this.cla.equals(newArrClausulas))
      {
         if (this.cla != null)
         {
            ArrClausulas oldArrClausulas = this.cla;
            this.cla = null;
            oldArrClausulas.removeIte(this);
         }
         if (newArrClausulas != null)
         {
            this.cla = newArrClausulas;
            this.cla.addIte(this);
         }
      }
   }

}