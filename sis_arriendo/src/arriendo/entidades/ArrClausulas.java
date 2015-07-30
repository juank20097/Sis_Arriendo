/***********************************************************************
 * Module:  ArrClausulas.java
 * Author:  jestevez
 * Purpose: Defines the Class ArrClausulas
 ***********************************************************************/

package arriendo.entidades;


/** @pdOid b5403d3b-29f6-4b3f-a800-0871eb83db32 */
public class ArrClausulas {
   /** @pdOid ec1c86d6-7ca9-42cb-93ca-de673bb26718 */
   private Integer claId;
   /** @pdOid b86c73ce-c488-48d4-ad4b-63e4da5fc1ae */
   private String claNombre;
   /** @pdOid dab99436-4422-43d7-ad7e-e5141f26e012 */
   private String claDescripcion;
   
   /** @pdOid 8bc2836c-5402-45ce-9f56-be74abf39212 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ArrItems assc=association6 coll=java.util.List mult=* */
   public java.util.List<ArrItems> ite;
   /** @pdRoleInfo migr=no name=ArrInter assc=association5 coll=java.util.List mult=* side=A */
   public java.util.List<ArrInter> intc;
   
   /** @pdOid 437fc6c9-2f48-4165-9af7-f324cd8c1c1c */
   public ArrClausulas() {
      // TODO: implement
   }
   
   /** @pdOid 8a4503c1-e886-479c-9521-cdad551955a3 */
   public Integer getClaId() {
      return claId;
   }
   
   /** @param newClaId
    * @pdOid 406d9b0a-003e-4efa-b9b8-18280e034496 */
   public void setClaId(Integer newClaId) {
      claId = newClaId;
   }
   
   /** @pdOid 0bec3b45-ef07-4850-b995-320a34442202 */
   public String getClaNombre() {
      return claNombre;
   }
   
   /** @param newClaNombre
    * @pdOid e30d2952-bae2-472e-8eaf-5158599cba5a */
   public void setClaNombre(String newClaNombre) {
      claNombre = newClaNombre;
   }
   
   /** @pdOid ed665e86-df04-4a35-b07e-da06c2d7b08c */
   public String getClaDescripcion() {
      return claDescripcion;
   }
   
   /** @param newClaDescripcion
    * @pdOid 8582c2c7-ed2e-44c1-86ce-8f830b745df6 */
   public void setClaDescripcion(String newClaDescripcion) {
      claDescripcion = newClaDescripcion;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<ArrItems> getIte() {
      if (ite == null)
         ite = new java.util.Vector<ArrItems>();
      return ite;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIte() {
      if (ite == null)
         ite = new java.util.Vector<ArrItems>();
      return ite.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIte */
   public void setIte(java.util.List<ArrItems> newIte) {
      removeAllIte();
      for (java.util.Iterator iter = newIte.iterator(); iter.hasNext();)
         addIte((ArrItems)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArrItems */
   public void addIte(ArrItems newArrItems) {
      if (newArrItems == null)
         return;
      if (this.ite == null)
         this.ite = new java.util.Vector<ArrItems>();
      if (!this.ite.contains(newArrItems))
      {
         this.ite.add(newArrItems);
         newArrItems.setCla(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldArrItems */
   public void removeIte(ArrItems oldArrItems) {
      if (oldArrItems == null)
         return;
      if (this.ite != null)
         if (this.ite.contains(oldArrItems))
         {
            this.ite.remove(oldArrItems);
            oldArrItems.setCla((ArrClausulas)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIte() {
      if (ite != null)
      {
         ArrItems oldArrItems;
         for (java.util.Iterator iter = getIteratorIte(); iter.hasNext();)
         {
            oldArrItems = (ArrItems)iter.next();
            iter.remove();
            oldArrItems.setCla((ArrClausulas)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ArrInter> getIntc() {
      if (intc == null)
         intc = new java.util.Vector<ArrInter>();
      return intc;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIntc() {
      if (intc == null)
         intc = new java.util.Vector<ArrInter>();
      return intc.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIntc */
   public void setIntc(java.util.List<ArrInter> newIntc) {
      removeAllIntc();
      for (java.util.Iterator iter = newIntc.iterator(); iter.hasNext();)
         addIntc((ArrInter)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArrInter */
   public void addIntc(ArrInter newArrInter) {
      if (newArrInter == null)
         return;
      if (this.intc == null)
         this.intc = new java.util.Vector<ArrInter>();
      if (!this.intc.contains(newArrInter))
      {
         this.intc.add(newArrInter);
         newArrInter.setCla(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldArrInter */
   public void removeIntc(ArrInter oldArrInter) {
      if (oldArrInter == null)
         return;
      if (this.intc != null)
         if (this.intc.contains(oldArrInter))
         {
            this.intc.remove(oldArrInter);
            oldArrInter.setCla((ArrClausulas)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIntc() {
      if (intc != null)
      {
         ArrInter oldArrInter;
         for (java.util.Iterator iter = getIteratorIntc(); iter.hasNext();)
         {
            oldArrInter = (ArrInter)iter.next();
            iter.remove();
            oldArrInter.setCla((ArrClausulas)null);
         }
      }
   }

}