/***********************************************************************
 * Module:  GenPersona.java
 * Author:  jestevez
 * Purpose: Defines the Class GenPersona
 ***********************************************************************/

package arriendo.Entidades;

import java.util.*;

/** @pdOid 88f75b31-4f5c-4c08-a3e6-5744921df57a */
public class GenPersona {
   /** @pdOid a9099c18-17ca-4ff9-b6f7-6c80872b2945 */
   private String perId;
   /** @pdOid 2c883d0a-3569-4603-b8d8-d9dda2919dea */
   private String perTipoId;
   /** @pdOid 2a68c1c3-6ca2-4f17-8804-d53435546f57 */
   private String perNombre;
   /** @pdOid 39f7a141-f159-454e-bf66-46761b1581d8 */
   private String perApellido;
   /** @pdOid 3bbd5d4a-4c5a-4b8f-8aa9-094b0041e33e */
   private String perTelefono;
   /** @pdOid dfe71f3c-75a8-4178-ab47-507d7958fba6 */
   private String perCelular;
   /** @pdOid 5c21f9fc-5b22-40e2-8f5c-eb9f9a692fbc */
   private char perGenero;
   
   /** @pdOid 99931c8d-f9b8-4c91-8909-abf6821b507f */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GenTipo assc=association7 mult=1..1 */
   public GenTipo tip;
   /** @pdRoleInfo migr=no name=ArrInterPer assc=association11 coll=java.util.List mult=* side=A */
   public java.util.List<ArrInterPer> intp;
   
   /** @pdOid 3e7f043e-e79d-4c5b-bb83-7981f647855d */
   public GenPersona() {
      // TODO: implement
   }
   
   /** @pdOid 39bdaeb6-ac79-4584-90e1-52b2e1998272 */
   public String getPerId() {
      return perId;
   }
   
   /** @param newPerId
    * @pdOid 5995b4d4-cfe7-42ff-b7f8-9f387fe6a200 */
   public void setPerId(String newPerId) {
      perId = newPerId;
   }
   
   /** @pdOid d4041021-73d0-435a-97f6-e284301a415e */
   public String getPerTipoId() {
      return perTipoId;
   }
   
   /** @param newPerTipoId
    * @pdOid 25e2397c-6abe-41b2-9c36-2a4015142db0 */
   public void setPerTipoId(String newPerTipoId) {
      perTipoId = newPerTipoId;
   }
   
   /** @pdOid da3dcba1-c0de-4c13-9a1f-9893f566a3d4 */
   public String getPerNombre() {
      return perNombre;
   }
   
   /** @param newPerNombre
    * @pdOid 0a6faa1a-487d-428d-af8c-2a8092f32209 */
   public void setPerNombre(String newPerNombre) {
      perNombre = newPerNombre;
   }
   
   /** @pdOid ffa43a3b-75ef-4744-8cab-6eb033a9100f */
   public String getPerApellido() {
      return perApellido;
   }
   
   /** @param newPerApellido
    * @pdOid ff92f94f-af3c-46ac-99d2-0c4b49261166 */
   public void setPerApellido(String newPerApellido) {
      perApellido = newPerApellido;
   }
   
   /** @pdOid ff7ee036-9386-4eab-8670-b96d9a9509c9 */
   public String getPerTelefono() {
      return perTelefono;
   }
   
   /** @param newPerTelefono
    * @pdOid 0bd19637-74a1-4be1-b860-0d0e9166792a */
   public void setPerTelefono(String newPerTelefono) {
      perTelefono = newPerTelefono;
   }
   
   /** @pdOid 7ace870b-bb09-4e2d-83b2-ea22012d99da */
   public String getPerCelular() {
      return perCelular;
   }
   
   /** @param newPerCelular
    * @pdOid 515870c2-695f-4b4f-a232-34ef8b21235e */
   public void setPerCelular(String newPerCelular) {
      perCelular = newPerCelular;
   }
   
   /** @pdOid 00026c63-f886-4210-ab4d-9317de1fba5c */
   public char getPerGenero() {
      return perGenero;
   }
   
   /** @param newPerGenero
    * @pdOid d9cffd08-e32a-4c61-a6b6-94edaec1ec71 */
   public void setPerGenero(char newPerGenero) {
      perGenero = newPerGenero;
   }
   
   
   /** @pdGenerated default parent getter */
   public GenTipo getTip() {
      return tip;
   }
   
   /** @pdGenerated default parent setter
     * @param newGenTipo */
   public void setTip(GenTipo newGenTipo) {
      if (this.tip == null || !this.tip.equals(newGenTipo))
      {
         if (this.tip != null)
         {
            GenTipo oldGenTipo = this.tip;
            this.tip = null;
            oldGenTipo.removePer(this);
         }
         if (newGenTipo != null)
         {
            this.tip = newGenTipo;
            this.tip.addPer(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ArrInterPer> getIntp() {
      if (intp == null)
         intp = new java.util.Vector<ArrInterPer>();
      return intp;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIntp() {
      if (intp == null)
         intp = new java.util.Vector<ArrInterPer>();
      return intp.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIntp */
   public void setIntp(java.util.List<ArrInterPer> newIntp) {
      removeAllIntp();
      for (java.util.Iterator iter = newIntp.iterator(); iter.hasNext();)
         addIntp((ArrInterPer)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArrInterPer */
   public void addIntp(ArrInterPer newArrInterPer) {
      if (newArrInterPer == null)
         return;
      if (this.intp == null)
         this.intp = new java.util.Vector<ArrInterPer>();
      if (!this.intp.contains(newArrInterPer))
      {
         this.intp.add(newArrInterPer);
         newArrInterPer.setPer(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldArrInterPer */
   public void removeIntp(ArrInterPer oldArrInterPer) {
      if (oldArrInterPer == null)
         return;
      if (this.intp != null)
         if (this.intp.contains(oldArrInterPer))
         {
            this.intp.remove(oldArrInterPer);
            oldArrInterPer.setPer((GenPersona)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIntp() {
      if (intp != null)
      {
         ArrInterPer oldArrInterPer;
         for (java.util.Iterator iter = getIteratorIntp(); iter.hasNext();)
         {
            oldArrInterPer = (ArrInterPer)iter.next();
            iter.remove();
            oldArrInterPer.setPer((GenPersona)null);
         }
      }
   }

}