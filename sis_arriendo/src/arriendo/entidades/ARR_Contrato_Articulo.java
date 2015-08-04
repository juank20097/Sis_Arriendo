/***********************************************************************
 * Module:  ARR_Contrato_Articulo.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_Contrato_Articulo
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid d556c807-f34f-4d0e-a502-c53cae046dbf */
public class ARR_Contrato_Articulo {
   /** @pdOid 0d28f12c-f8a3-4171-a68f-920ef700f1e7 */
   private Integer ca_id;
   /** @pdOid 7679dbb0-b601-4a53-8eb7-8f7444d1c0e6 */
   private Integer art_id;
   /** @pdOid f9bff3ee-6bdc-4335-984a-5d1745748df6 */
   private String art_nombre;
   
   /** @pdOid 98e3d13f-e8e8-4066-ad9f-4bb4640131f1 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Contrato_Det assc=association14 coll=java.util.List mult=* */
   public java.util.List<ARR_Contrato_Det> con_det;
   
   /** @pdOid f50695d7-7944-46e1-9232-381f38e430a1 */
   public ARR_Contrato_Articulo() {
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
   
   /** @pdOid 6abafa85-5267-4588-a571-1f9a30f958da */
   public String getArt_nombre() {
      return art_nombre;
   }
   
   /** @param newArt_nombre
    * @pdOid df06cc3d-c833-4cfc-b19d-40cc0794b0c9 */
   public void setArt_nombre(String newArt_nombre) {
      art_nombre = newArt_nombre;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<ARR_Contrato_Det> getCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ARR_Contrato_Det>();
      return con_det;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ARR_Contrato_Det>();
      return con_det.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCon_det */
   public void setCon_det(java.util.List<ARR_Contrato_Det> newCon_det) {
      removeAllCon_det();
      for (java.util.Iterator iter = newCon_det.iterator(); iter.hasNext();)
         addCon_det((ARR_Contrato_Det)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_Contrato_Det */
   public void addCon_det(ARR_Contrato_Det newARR_Contrato_Det) {
      if (newARR_Contrato_Det == null)
         return;
      if (this.con_det == null)
         this.con_det = new java.util.Vector<ARR_Contrato_Det>();
      if (!this.con_det.contains(newARR_Contrato_Det))
      {
         this.con_det.add(newARR_Contrato_Det);
         newARR_Contrato_Det.setCon_art(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_Contrato_Det */
   public void removeCon_det(ARR_Contrato_Det oldARR_Contrato_Det) {
      if (oldARR_Contrato_Det == null)
         return;
      if (this.con_det != null)
         if (this.con_det.contains(oldARR_Contrato_Det))
         {
            this.con_det.remove(oldARR_Contrato_Det);
            oldARR_Contrato_Det.setCon_art((ARR_Contrato_Articulo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCon_det() {
      if (con_det != null)
      {
         ARR_Contrato_Det oldARR_Contrato_Det;
         for (java.util.Iterator iter = getIteratorCon_det(); iter.hasNext();)
         {
            oldARR_Contrato_Det = (ARR_Contrato_Det)iter.next();
            iter.remove();
            oldARR_Contrato_Det.setCon_art((ARR_Contrato_Articulo)null);
         }
      }
   }

}