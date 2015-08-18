/***********************************************************************
 * Module:  GEN_Sitios.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Sitios
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid c1e74da1-ac9d-4d1d-a238-2dd2ca5bdcb2 */
public class GEN_Sitios {
   /** @pdOid 9aa4df52-ed2b-4991-8e55-fc90ee69fe2a */
   private Integer sit_id;
   /** @pdOid 27af81cc-e239-4ea1-969f-ede08e243527 */
   private String sit_nombre;
   /** @pdOid ecc06041-8f9b-4045-b88e-42b6a1202d1f */
   private Double sit_costo_arriendo;
   /** @pdOid a0c52981-e808-4f64-911c-e4aa61fdcde0 */
   private Integer sit_capacidad;
   /** @pdOid c0175881-8fa7-40d2-acbf-79130b66b18d */
   private char sit_estado;
   
   /** @pdOid 3ac27362-b86c-4155-886d-69079f556918 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Contratos_Det assc=association2 coll=java.util.List mult=* */
   public java.util.List<ARR_Contratos_Det> con_det;
   /** @pdRoleInfo migr=no name=GEN_Areas assc=association9 mult=1..1 side=A */
   public GEN_Areas are;
   /** @pdRoleInfo migr=no name=GEN_TipoSitios assc=association17 mult=1..1 side=A */
   public GEN_TipoSitios tsi;
   /** @pdRoleInfo migr=no name=ARR_SitiosArticulos assc=association18 coll=java.util.List mult=* side=A */
   public java.util.List<ARR_SitiosArticulos> sa;
   
   /** @pdOid 2375d0b3-8d53-47ac-9789-b1ed5d971603 */
   public GEN_Sitios() {
      // TODO: implement
   }
   
   /** @pdOid 26eed235-5e5d-44e6-86f7-3f1b63bc5ff2 */
   public Integer getSit_id() {
      return sit_id;
   }
   
   /** @param newSit_id
    * @pdOid 2e4e0c58-b123-4a61-a68e-9c20ac256bc2 */
   public void setSit_id(Integer newSit_id) {
      sit_id = newSit_id;
   }
   
   /** @pdOid 5e797dac-aa5e-4e7b-a1ae-0f64af61cb6f */
   public Double getSit_costo_arriendo() {
      return sit_costo_arriendo;
   }
   
   /** @param newSit_costo_arriendo
    * @pdOid 7b090366-81bd-43d0-b73a-374d2ff81616 */
   public void setSit_costo_arriendo(Double newSit_costo_arriendo) {
      sit_costo_arriendo = newSit_costo_arriendo;
   }
   
   /** @pdOid 9ef0614f-df91-42c0-8039-5a22e008f652 */
   public Integer getSit_capacidad() {
      return sit_capacidad;
   }
   
   /** @param newSit_capacidad
    * @pdOid ef0b4497-6c3e-4dd9-a215-1f42b3b5ceeb */
   public void setSit_capacidad(Integer newSit_capacidad) {
      sit_capacidad = newSit_capacidad;
   }
   
   /** @pdOid 44878a61-4328-4378-86db-6c97b6608bb3 */
   public char getSit_estado() {
      return sit_estado;
   }
   
   /** @param newSit_estado
    * @pdOid 9145b465-2d63-4feb-ba22-0ffc144eb83b */
   public void setSit_estado(char newSit_estado) {
      sit_estado = newSit_estado;
   }
   
   /** @pdOid c4218a73-8104-4d6a-94a0-36ecb6c34a47 */
   public String getSit_nombre() {
      return sit_nombre;
   }
   
   /** @param newSit_nombre
    * @pdOid 55eca312-0e65-453c-b838-ab1f7ee1079e */
   public void setSit_nombre(String newSit_nombre) {
      sit_nombre = newSit_nombre;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<ARR_Contratos_Det> getCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ARR_Contratos_Det>();
      return con_det;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ARR_Contratos_Det>();
      return con_det.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCon_det */
   public void setCon_det(java.util.List<ARR_Contratos_Det> newCon_det) {
      removeAllCon_det();
      for (java.util.Iterator iter = newCon_det.iterator(); iter.hasNext();)
         addCon_det((ARR_Contratos_Det)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_Contratos_Det */
   public void addCon_det(ARR_Contratos_Det newARR_Contratos_Det) {
      if (newARR_Contratos_Det == null)
         return;
      if (this.con_det == null)
         this.con_det = new java.util.Vector<ARR_Contratos_Det>();
      if (!this.con_det.contains(newARR_Contratos_Det))
      {
         this.con_det.add(newARR_Contratos_Det);
         newARR_Contratos_Det.setSit(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_Contratos_Det */
   public void removeCon_det(ARR_Contratos_Det oldARR_Contratos_Det) {
      if (oldARR_Contratos_Det == null)
         return;
      if (this.con_det != null)
         if (this.con_det.contains(oldARR_Contratos_Det))
         {
            this.con_det.remove(oldARR_Contratos_Det);
            oldARR_Contratos_Det.setSit((GEN_Sitios)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCon_det() {
      if (con_det != null)
      {
         ARR_Contratos_Det oldARR_Contratos_Det;
         for (java.util.Iterator iter = getIteratorCon_det(); iter.hasNext();)
         {
            oldARR_Contratos_Det = (ARR_Contratos_Det)iter.next();
            iter.remove();
            oldARR_Contratos_Det.setSit((GEN_Sitios)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GEN_Areas getAre() {
      return are;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_Areas */
   public void setAre(GEN_Areas newGEN_Areas) {
      if (this.are == null || !this.are.equals(newGEN_Areas))
      {
       /*  if (this.are != null)
         {
            GEN_Areas oldGEN_Areas = this.are;
            this.are = null;
            oldGEN_Areas.removeSit(this);
         } */
         if (newGEN_Areas != null)
         {
            this.are = newGEN_Areas;
            this.are.addSit(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GEN_TipoSitios getTsi() {
      return tsi;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_TipoSitios */
   public void setTsi(GEN_TipoSitios newGEN_TipoSitios) {
      if (this.tsi == null || !this.tsi.equals(newGEN_TipoSitios))
      {
         if (this.tsi != null)
         {
            GEN_TipoSitios oldGEN_TipoSitios = this.tsi;
            this.tsi = null;
            oldGEN_TipoSitios.removeSit(this);
         }
         if (newGEN_TipoSitios != null)
         {
            this.tsi = newGEN_TipoSitios;
            this.tsi.addSit(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ARR_SitiosArticulos> getSa() {
      if (sa == null)
         sa = new java.util.Vector<ARR_SitiosArticulos>();
      return sa;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSa() {
      if (sa == null)
         sa = new java.util.Vector<ARR_SitiosArticulos>();
      return sa.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSa */
   public void setSa(java.util.List<ARR_SitiosArticulos> newSa) {
      removeAllSa();
      for (java.util.Iterator iter = newSa.iterator(); iter.hasNext();)
         addSa((ARR_SitiosArticulos)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_SitiosArticulos */
   public void addSa(ARR_SitiosArticulos newARR_SitiosArticulos) {
      if (newARR_SitiosArticulos == null)
         return;
      if (this.sa == null)
         this.sa = new java.util.Vector<ARR_SitiosArticulos>();
      if (!this.sa.contains(newARR_SitiosArticulos))
      {
         this.sa.add(newARR_SitiosArticulos);
         newARR_SitiosArticulos.setSit(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_SitiosArticulos */
   public void removeSa(ARR_SitiosArticulos oldARR_SitiosArticulos) {
      if (oldARR_SitiosArticulos == null)
         return;
      if (this.sa != null)
         if (this.sa.contains(oldARR_SitiosArticulos))
         {
            this.sa.remove(oldARR_SitiosArticulos);
            oldARR_SitiosArticulos.setSit((GEN_Sitios)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSa() {
      if (sa != null)
      {
         ARR_SitiosArticulos oldARR_SitiosArticulos;
         for (java.util.Iterator iter = getIteratorSa(); iter.hasNext();)
         {
            oldARR_SitiosArticulos = (ARR_SitiosArticulos)iter.next();
            iter.remove();
            oldARR_SitiosArticulos.setSit((GEN_Sitios)null);
         }
      }
   }

}