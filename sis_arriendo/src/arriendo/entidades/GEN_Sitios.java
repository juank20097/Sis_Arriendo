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
   private String sit_identificador;
   /** @pdOid ecc06041-8f9b-4045-b88e-42b6a1202d1f */
   private Double sit_costo_arriendo;
   /** @pdOid d39f1d49-eada-48ff-9cbc-7f67b97ba421 */
   private String sit_direccion;
   /** @pdOid a0c52981-e808-4f64-911c-e4aa61fdcde0 */
   private Integer sit_capacidad;
   /** @pdOid c0175881-8fa7-40d2-acbf-79130b66b18d */
   private Integer sit_estado = 1;
   
   /** @pdOid 3ac27362-b86c-4155-886d-69079f556918 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Articulos assc=association1 coll=java.util.List mult=* */
   public java.util.List<GEN_Articulos> art;
   /** @pdRoleInfo migr=no name=ARR_Contrato_Det assc=association2 coll=java.util.List mult=* */
   public java.util.List<ARR_Contrato_Det> con_det;
   /** @pdRoleInfo migr=no name=GEN_Area assc=association9 mult=1..1 side=A */
   public GEN_Area are;
   
   /** @pdOid 2375d0b3-8d53-47ac-9789-b1ed5d971603 */
   public GEN_Sitios() {
      // TODO: implement
   }
   
   /** @pdOid 26eed235-5e5d-44e6-86f7-3f1b63bc5ff2 */
   public String getSit_identificador() {
      return sit_identificador;
   }
   
   /** @param newSit_identificador
    * @pdOid 2e4e0c58-b123-4a61-a68e-9c20ac256bc2 */
   public void setSit_identificador(String newSit_identificador) {
      sit_identificador = newSit_identificador;
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
   
   /** @pdOid ca5088b7-bae9-4354-afa6-01292b61eba4 */
   public String getSit_direccion() {
      return sit_direccion;
   }
   
   /** @param newSit_direccion
    * @pdOid cabe594d-c313-480b-a8a5-c4d5b04ed584 */
   public void setSit_direccion(String newSit_direccion) {
      sit_direccion = newSit_direccion;
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
   public Integer getSit_estado() {
      return sit_estado;
   }
   
   /** @param newSit_estado
    * @pdOid 9145b465-2d63-4feb-ba22-0ffc144eb83b */
   public void setSit_estado(Integer newSit_estado) {
      sit_estado = newSit_estado;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GEN_Articulos> getArt() {
      if (art == null)
         art = new java.util.Vector<GEN_Articulos>();
      return art;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorArt() {
      if (art == null)
         art = new java.util.Vector<GEN_Articulos>();
      return art.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArt */
   public void setArt(java.util.List<GEN_Articulos> newArt) {
      removeAllArt();
      for (java.util.Iterator iter = newArt.iterator(); iter.hasNext();)
         addArt((GEN_Articulos)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGEN_Articulos */
   public void addArt(GEN_Articulos newGEN_Articulos) {
      if (newGEN_Articulos == null)
         return;
      if (this.art == null)
         this.art = new java.util.Vector<GEN_Articulos>();
      if (!this.art.contains(newGEN_Articulos))
      {
         this.art.add(newGEN_Articulos);
         newGEN_Articulos.setSit(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGEN_Articulos */
   public void removeArt(GEN_Articulos oldGEN_Articulos) {
      if (oldGEN_Articulos == null)
         return;
      if (this.art != null)
         if (this.art.contains(oldGEN_Articulos))
         {
            this.art.remove(oldGEN_Articulos);
            oldGEN_Articulos.setSit((GEN_Sitios)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllArt() {
      if (art != null)
      {
         GEN_Articulos oldGEN_Articulos;
         for (java.util.Iterator iter = getIteratorArt(); iter.hasNext();)
         {
            oldGEN_Articulos = (GEN_Articulos)iter.next();
            iter.remove();
            oldGEN_Articulos.setSit((GEN_Sitios)null);
         }
      }
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
         newARR_Contrato_Det.setSit(this);      
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
            oldARR_Contrato_Det.setSit((GEN_Sitios)null);
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
            oldARR_Contrato_Det.setSit((GEN_Sitios)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GEN_Area getAre() {
      return are;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_Area */
   public void setAre(GEN_Area newGEN_Area) {
      if (this.are == null || !this.are.equals(newGEN_Area))
      {
         if (this.are != null)
         {
            GEN_Area oldGEN_Area = this.are;
            this.are = null;
            oldGEN_Area.removeSit(this);
         }
         if (newGEN_Area != null)
         {
            this.are = newGEN_Area;
            this.are.addSit(this);
         }
      }
   }

}