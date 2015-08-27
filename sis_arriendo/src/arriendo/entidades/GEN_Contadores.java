/***********************************************************************
 * Module:  GEN_Contadores.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Contadores
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 41941724-655f-44e7-9886-c40bc1b9c875 */
public class GEN_Contadores {
   /** @pdOid fe7c39d2-a0e1-4b4a-a41a-ec05a4c4b71c */
   private Integer cnt_id;
   /** @pdOid 7dbbcd7e-c019-481f-914f-79b6ebb302bb */
   private String cnt_clave;
   /** @pdOid 0cc87298-2d89-49fa-aded-4b97c3efe171 */
   private Integer cnt_valor;
   
   /** @pdOid f2589cb6-cd5b-44f7-9367-a5c75e613600 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid 0d928ec9-337a-4e4f-8403-3b4580582f34 */
   public GEN_Contadores() {
      // TODO: implement
   }
   
   /** @pdOid 1fd65d88-ed26-4970-b5f9-ab29755ec6d6 */
   public Integer getCnt_id() {
      return cnt_id;
   }
   
   /** @param newCnt_id
    * @pdOid f4f609af-8643-443d-967d-0239d9c835d6 */
   public void setCnt_id(Integer newCnt_id) {
      cnt_id = newCnt_id;
   }
   
   /** @pdOid 824388c9-0a80-48da-bf44-4a812c5ff8e9 */
   public String getCnt_clave() {
      return cnt_clave;
   }
   
   /** @param newCnt_clave
    * @pdOid 73302644-f53f-4d3c-b350-a8d0f5dfb0c6 */
   public void setCnt_clave(String newCnt_clave) {
      cnt_clave = newCnt_clave;
   }
   
   /** @pdOid 8395fad8-e907-4de2-8c1a-929f54c7e11f */
   public Integer getCnt_valor() {
      return cnt_valor;
   }
   
   /** @param newCnt_valor
    * @pdOid 55832503-71e7-468c-9557-ffcb5ccdcd05 */
   public void setCnt_valor(Integer newCnt_valor) {
      cnt_valor = newCnt_valor;
   }

}