/***********************************************************************
 * Module:  GEN_Persona.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Persona
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 88f75b31-4f5c-4c08-a3e6-5744921df57a */
public class GEN_Persona {
   /** @pdOid a9099c18-17ca-4ff9-b6f7-6c80872b2945 */
   private String per_id;
   /** @pdOid 2c883d0a-3569-4603-b8d8-d9dda2919dea */
   private String per_tipo_id;
   /** @pdOid 2a68c1c3-6ca2-4f17-8804-d53435546f57 */
   private String per_nombre;
   /** @pdOid 39f7a141-f159-454e-bf66-46761b1581d8 */
   private String per_apellido;
   /** @pdOid 3bbd5d4a-4c5a-4b8f-8aa9-094b0041e33e */
   private String per_telefono;
   /** @pdOid dfe71f3c-75a8-4178-ab47-507d7958fba6 */
   private String per_celular;
   /** @pdOid 5c21f9fc-5b22-40e2-8f5c-eb9f9a692fbc */
   private char per_genero;
   
   /** @pdOid 99931c8d-f9b8-4c91-8909-abf6821b507f */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Tipo assc=association7 mult=1..1 */
   public GEN_Tipo tip;
   /** @pdRoleInfo migr=no name=ARR_Inter_Per assc=association11 coll=java.util.List mult=* side=A */
   public java.util.List<ARR_Inter_Per> intp;
   
   /** @pdOid 3e7f043e-e79d-4c5b-bb83-7981f647855d */
   public GEN_Persona() {
      // TODO: implement
   }
   
   /** @pdOid 39bdaeb6-ac79-4584-90e1-52b2e1998272 */
   public String getPer_id() {
      return per_id;
   }
   
   /** @param newPer_id
    * @pdOid 5995b4d4-cfe7-42ff-b7f8-9f387fe6a200 */
   public void setPer_id(String newPer_id) {
      per_id = newPer_id;
   }
   
   /** @pdOid d4041021-73d0-435a-97f6-e284301a415e */
   public String getPer_tipo_id() {
      return per_tipo_id;
   }
   
   /** @param newPer_tipo_id
    * @pdOid 25e2397c-6abe-41b2-9c36-2a4015142db0 */
   public void setPer_tipo_id(String newPer_tipo_id) {
      per_tipo_id = newPer_tipo_id;
   }
   
   /** @pdOid da3dcba1-c0de-4c13-9a1f-9893f566a3d4 */
   public String getPer_nombre() {
      return per_nombre;
   }
   
   /** @param newPer_nombre
    * @pdOid 0a6faa1a-487d-428d-af8c-2a8092f32209 */
   public void setPer_nombre(String newPer_nombre) {
      per_nombre = newPer_nombre;
   }
   
   /** @pdOid ffa43a3b-75ef-4744-8cab-6eb033a9100f */
   public String getPer_apellido() {
      return per_apellido;
   }
   
   /** @param newPer_apellido
    * @pdOid ff92f94f-af3c-46ac-99d2-0c4b49261166 */
   public void setPer_apellido(String newPer_apellido) {
      per_apellido = newPer_apellido;
   }
   
   /** @pdOid ff7ee036-9386-4eab-8670-b96d9a9509c9 */
   public String getPer_telefono() {
      return per_telefono;
   }
   
   /** @param newPer_telefono
    * @pdOid 0bd19637-74a1-4be1-b860-0d0e9166792a */
   public void setPer_telefono(String newPer_telefono) {
      per_telefono = newPer_telefono;
   }
   
   /** @pdOid 7ace870b-bb09-4e2d-83b2-ea22012d99da */
   public String getPer_celular() {
      return per_celular;
   }
   
   /** @param newPer_celular
    * @pdOid 515870c2-695f-4b4f-a232-34ef8b21235e */
   public void setPer_celular(String newPer_celular) {
      per_celular = newPer_celular;
   }
   
   /** @pdOid 00026c63-f886-4210-ab4d-9317de1fba5c */
   public char getPer_genero() {
      return per_genero;
   }
   
   /** @param newPer_genero
    * @pdOid d9cffd08-e32a-4c61-a6b6-94edaec1ec71 */
   public void setPer_genero(char newPer_genero) {
      per_genero = newPer_genero;
   }
   
   
   /** @pdGenerated default parent getter */
   public GEN_Tipo getTip() {
      return tip;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_Tipo */
   public void setTip(GEN_Tipo newGEN_Tipo) {
      if (this.tip == null || !this.tip.equals(newGEN_Tipo))
      {
         if (this.tip != null)
         {
            GEN_Tipo oldGEN_Tipo = this.tip;
            this.tip = null;
            oldGEN_Tipo.removePer(this);
         }
         if (newGEN_Tipo != null)
         {
            this.tip = newGEN_Tipo;
            this.tip.addPer(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ARR_Inter_Per> getIntp() {
      if (intp == null)
         intp = new java.util.Vector<ARR_Inter_Per>();
      return intp;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIntp() {
      if (intp == null)
         intp = new java.util.Vector<ARR_Inter_Per>();
      return intp.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIntp */
   public void setIntp(java.util.List<ARR_Inter_Per> newIntp) {
      removeAllIntp();
      for (java.util.Iterator iter = newIntp.iterator(); iter.hasNext();)
         addIntp((ARR_Inter_Per)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_Inter_Per */
   public void addIntp(ARR_Inter_Per newARR_Inter_Per) {
      if (newARR_Inter_Per == null)
         return;
      if (this.intp == null)
         this.intp = new java.util.Vector<ARR_Inter_Per>();
      if (!this.intp.contains(newARR_Inter_Per))
      {
         this.intp.add(newARR_Inter_Per);
         newARR_Inter_Per.setPer(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_Inter_Per */
   public void removeIntp(ARR_Inter_Per oldARR_Inter_Per) {
      if (oldARR_Inter_Per == null)
         return;
      if (this.intp != null)
         if (this.intp.contains(oldARR_Inter_Per))
         {
            this.intp.remove(oldARR_Inter_Per);
            oldARR_Inter_Per.setPer((GEN_Persona)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIntp() {
      if (intp != null)
      {
         ARR_Inter_Per oldARR_Inter_Per;
         for (java.util.Iterator iter = getIteratorIntp(); iter.hasNext();)
         {
            oldARR_Inter_Per = (ARR_Inter_Per)iter.next();
            iter.remove();
            oldARR_Inter_Per.setPer((GEN_Persona)null);
         }
      }
   }

}