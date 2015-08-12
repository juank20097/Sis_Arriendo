/***********************************************************************
 * Module:  GEN_Docentes.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Docentes
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 6b77c3b3-2fc2-4802-9f4f-2dcb980e1623 */
public class GEN_Docentes extends GEN_Personas {
   /** @pdOid 1b9f98cc-d961-472e-8fca-f799aa12ba82 */
   private int doc_titulo;
   
   /** @pdOid 7b0003c8-6a8e-465d-9682-3b276f5c224a */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid db613c34-a79e-4ff9-b7e9-0f8c10032973 */
   public int getDoc_titulo() {
      return doc_titulo;
   }
   
   /** @param newDoc_titulo
    * @pdOid b48f0ea9-c8c8-4f7c-b3d6-77aac82dccb4 */
   public void setDoc_titulo(int newDoc_titulo) {
      doc_titulo = newDoc_titulo;
   }
   
   /** @pdOid ef098054-10a7-4961-9d5c-325e80d9c924 */
   public GEN_Docentes() {
      // TODO: implement
   }

}