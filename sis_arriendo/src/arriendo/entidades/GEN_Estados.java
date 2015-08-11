/***********************************************************************
 * Module:  GEN_Estados.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Estados
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 58459eac-efe5-454e-8cee-33dc14bcfcf7 */
public class GEN_Estados {
   /** @pdOid 19a6ae75-1f45-4d0d-9a5d-6859502db525 */
   private char est_id;
   /** @pdOid f82f55c0-fda3-435e-8708-1a5c688ba88c */
   private String est_nombre;
   /** @pdOid 452de288-8c05-4b03-839c-d789ae40c251 */
   private String est_descripcion;
   
   /** @pdOid b851a692-1a8c-486c-987f-f72435246388 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid dc96d36c-7eab-465f-91e0-935a0c50201a */
   public GEN_Estados() {
      // TODO: implement
   }
   
   /** @pdOid 81c1927e-bf64-41e9-97da-d21d4d4cd643 */
   public char getEst_id() {
      return est_id;
   }
   
   /** @param newEst_id
    * @pdOid b4744565-b7f8-40d2-a94b-7f10ce43ff28 */
   public void setEst_id(char newEst_id) {
      est_id = newEst_id;
   }
   
   /** @pdOid 4bd69054-99b5-4f27-9545-d1e9c03bbc69 */
   public String getEst_nombre() {
      return est_nombre;
   }
   
   /** @param newEst_nombre
    * @pdOid 5cc06926-ef8e-447f-8af9-7cbd729e5139 */
   public void setEst_nombre(String newEst_nombre) {
      est_nombre = newEst_nombre;
   }
   
   /** @pdOid 55d6aee6-64fe-42f6-aaec-5a5042e5fa1d */
   public String getEst_descripcion() {
      return est_descripcion;
   }
   
   /** @param newEst_descripcion
    * @pdOid e15d431a-b7a3-4fea-9c4c-0491d24ec44c */
   public void setEst_descripcion(String newEst_descripcion) {
      est_descripcion = newEst_descripcion;
   }

}