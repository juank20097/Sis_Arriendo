/***********************************************************************
 * Module:  GenSitios.java
 * Author:  jestevez
 * Purpose: Defines the Class GenSitios
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid c1e74da1-ac9d-4d1d-a238-2dd2ca5bdcb2 */
public class GenSitios {
   /** @pdOid 9aa4df52-ed2b-4991-8e55-fc90ee69fe2a */
   private String sitIdentificador;
   /** @pdOid ecc06041-8f9b-4045-b88e-42b6a1202d1f */
   private Double sitCostoArriendo;
   /** @pdOid d39f1d49-eada-48ff-9cbc-7f67b97ba421 */
   private String sitDireccion;
   /** @pdOid a0c52981-e808-4f64-911c-e4aa61fdcde0 */
   private Integer sitCapacidad;
   /** @pdOid c0175881-8fa7-40d2-acbf-79130b66b18d */
   private char sitEstado = 1;
   
   /** @pdOid 3ac27362-b86c-4155-886d-69079f556918 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GenArticulos assc=association1 mult=* */
   public GenArticulos[] art;
   /** @pdRoleInfo migr=no name=ArrContratoDet assc=association2 coll=java.util.List mult=* */
   public java.util.List<ArrContratoDet> con_det;
   /** @pdRoleInfo migr=no name=GenModo assc=association8 mult=1..1 side=A */
   public GenModo mod;
   /** @pdRoleInfo migr=no name=GenArea assc=association9 mult=1..1 side=A */
   public GenArea are;
   
   /** @pdOid 2375d0b3-8d53-47ac-9789-b1ed5d971603 */
   public GenSitios() {
      // TODO: implement
   }
   
   /** @pdOid 26eed235-5e5d-44e6-86f7-3f1b63bc5ff2 */
   public String getSitIdentificador() {
      return sitIdentificador;
   }
   
   /** @param newSitIdentificador
    * @pdOid 2e4e0c58-b123-4a61-a68e-9c20ac256bc2 */
   public void setSitIdentificador(String newSitIdentificador) {
      sitIdentificador = newSitIdentificador;
   }
   
   /** @pdOid 5e797dac-aa5e-4e7b-a1ae-0f64af61cb6f */
   public Double getSitCostoArriendo() {
      return sitCostoArriendo;
   }
   
   /** @param newSitCostoArriendo
    * @pdOid 7b090366-81bd-43d0-b73a-374d2ff81616 */
   public void setSitCostoArriendo(Double newSitCostoArriendo) {
      sitCostoArriendo = newSitCostoArriendo;
   }
   
   /** @pdOid ca5088b7-bae9-4354-afa6-01292b61eba4 */
   public String getSitDireccion() {
      return sitDireccion;
   }
   
   /** @param newSitDireccion
    * @pdOid cabe594d-c313-480b-a8a5-c4d5b04ed584 */
   public void setSitDireccion(String newSitDireccion) {
      sitDireccion = newSitDireccion;
   }
   
   /** @pdOid 9ef0614f-df91-42c0-8039-5a22e008f652 */
   public Integer getSitCapacidad() {
      return sitCapacidad;
   }
   
   /** @param newSitCapacidad
    * @pdOid ef0b4497-6c3e-4dd9-a215-1f42b3b5ceeb */
   public void setSitCapacidad(Integer newSitCapacidad) {
      sitCapacidad = newSitCapacidad;
   }
   
   /** @pdOid 44878a61-4328-4378-86db-6c97b6608bb3 */
   public char getSitEstado() {
      return sitEstado;
   }
   
   /** @param newSitEstado
    * @pdOid 9145b465-2d63-4feb-ba22-0ffc144eb83b */
   public void setSitEstado(char newSitEstado) {
      sitEstado = newSitEstado;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<ArrContratoDet> getCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ArrContratoDet>();
      return con_det;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCon_det() {
      if (con_det == null)
         con_det = new java.util.Vector<ArrContratoDet>();
      return con_det.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCon_det */
   public void setCon_det(java.util.List<ArrContratoDet> newCon_det) {
      removeAllCon_det();
      for (java.util.Iterator iter = newCon_det.iterator(); iter.hasNext();)
         addCon_det((ArrContratoDet)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArrContratoDet */
   public void addCon_det(ArrContratoDet newArrContratoDet) {
      if (newArrContratoDet == null)
         return;
      if (this.con_det == null)
         this.con_det = new java.util.Vector<ArrContratoDet>();
      if (!this.con_det.contains(newArrContratoDet))
      {
         this.con_det.add(newArrContratoDet);
         newArrContratoDet.setSit(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldArrContratoDet */
   public void removeCon_det(ArrContratoDet oldArrContratoDet) {
      if (oldArrContratoDet == null)
         return;
      if (this.con_det != null)
         if (this.con_det.contains(oldArrContratoDet))
         {
            this.con_det.remove(oldArrContratoDet);
            oldArrContratoDet.setSit((GenSitios)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCon_det() {
      if (con_det != null)
      {
         ArrContratoDet oldArrContratoDet;
         for (java.util.Iterator iter = getIteratorCon_det(); iter.hasNext();)
         {
            oldArrContratoDet = (ArrContratoDet)iter.next();
            iter.remove();
            oldArrContratoDet.setSit((GenSitios)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GenModo getMod() {
      return mod;
   }
   
   /** @pdGenerated default parent setter
     * @param newGenModo */
   public void setMod(GenModo newGenModo) {
      if (this.mod == null || !this.mod.equals(newGenModo))
      {
         if (this.mod != null)
         {
            GenModo oldGenModo = this.mod;
            this.mod = null;
            oldGenModo.removeSit(this);
         }
         if (newGenModo != null)
         {
            this.mod = newGenModo;
            this.mod.addSit(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GenArea getAre() {
      return are;
   }
   
   /** @pdGenerated default parent setter
     * @param newGenArea */
   public void setAre(GenArea newGenArea) {
      if (this.are == null || !this.are.equals(newGenArea))
      {
         if (this.are != null)
         {
            GenArea oldGenArea = this.are;
            this.are = null;
            oldGenArea.removeSit(this);
         }
         if (newGenArea != null)
         {
            this.are = newGenArea;
            this.are.addSit(this);
         }
      }
   }

}