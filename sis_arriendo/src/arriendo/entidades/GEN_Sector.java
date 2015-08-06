/***********************************************************************
 * Module:  GEN_Sector.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Sector
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 9d11dc03-c773-4afa-977a-8d2452c217be */
public class GEN_Sector {
   /** @pdOid c856cac0-2a99-4616-9af0-fd043ac5e07c */
   private Integer sec_id;
   /** @pdOid 664cdc30-b8aa-4e81-b9e2-887b6cb8e2dd */
   private String sec_nombre;
   /** @pdOid 9916231a-3227-4cb1-af79-f6a0ab3a485f */
   private String sec_direccion;
   /** @pdOid 37d6d1df-036f-4136-8bb9-6b95cd4b7000 */
   private String sec_estado;
   /** @pdOid 451134ab-3506-473f-9573-f12b0d994478 */
   private String sec_ubicacion;
   
   /** @pdOid d5c63bce-8878-4c31-b8a2-0c53cd8a3ab2 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Area assc=association16 coll=java.util.List mult=* */
   public java.util.List<GEN_Area> are;
   /** @pdRoleInfo migr=no name=GEN_Institucion assc=association15 mult=1..1 side=A */
   public GEN_Institucion ins;
   
   /** @pdOid 2de0b5b1-b693-4636-83d1-e80aff2ad14f */
   public GEN_Sector() {
      // TODO: implement
   }
   
   /** @pdOid 0f9e68d6-4f29-4a10-aab2-10ab2ccff94f */
   public Integer getSec_id() {
      return sec_id;
   }
   
   /** @param newSec_id
    * @pdOid ee51784a-ba7b-4a9f-b287-d2a8216d6872 */
   public void setSec_id(Integer newSec_id) {
      sec_id = newSec_id;
   }
   
   /** @pdOid ff8c8ac1-a141-49c9-a8d4-a61e1350cf52 */
   public String getSec_nombre() {
      return sec_nombre;
   }
   
   /** @param newSec_nombre
    * @pdOid 7d5fe06f-1c54-45f9-bebb-23becfeaf80f */
   public void setSec_nombre(String newSec_nombre) {
      sec_nombre = newSec_nombre;
   }
   
   /** @pdOid 8f8b024a-6a35-44eb-9560-f796f19ff4e9 */
   public String getSec_direccion() {
      return sec_direccion;
   }
   
   /** @param newSec_direccion
    * @pdOid 8140b6a5-1455-4d68-a1b5-a41c6be9c7be */
   public void setSec_direccion(String newSec_direccion) {
      sec_direccion = newSec_direccion;
   }
   
   /** @pdOid a8aa5b4a-12fc-450c-88c0-37eec0f33b74 */
   public String getSec_estado() {
      return sec_estado;
   }
   
   /** @param newSec_estado
    * @pdOid 4df03dfb-abcd-4345-8efc-16036c9775d2 */
   public void setSec_estado(String newSec_estado) {
      sec_estado = newSec_estado;
   }
   
   /** @pdOid 5958d782-846d-4124-88f2-df4abf15498b */
   public String getSec_ubicacion() {
      return sec_ubicacion;
   }
   
   /** @param newSec_ubicacion
    * @pdOid c756e5fb-0fa6-4967-a268-e0bf0f42c7fa */
   public void setSec_ubicacion(String newSec_ubicacion) {
      sec_ubicacion = newSec_ubicacion;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GEN_Area> getAre() {
      if (are == null)
         are = new java.util.Vector<GEN_Area>();
      return are;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAre() {
      if (are == null)
         are = new java.util.Vector<GEN_Area>();
      return are.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAre */
   public void setAre(java.util.List<GEN_Area> newAre) {
      removeAllAre();
      for (java.util.Iterator iter = newAre.iterator(); iter.hasNext();)
         addAre((GEN_Area)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGEN_Area */
   public void addAre(GEN_Area newGEN_Area) {
      if (newGEN_Area == null)
         return;
      if (this.are == null)
         this.are = new java.util.Vector<GEN_Area>();
      if (!this.are.contains(newGEN_Area))
      {
         this.are.add(newGEN_Area);
         newGEN_Area.setSec(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGEN_Area */
   public void removeAre(GEN_Area oldGEN_Area) {
      if (oldGEN_Area == null)
         return;
      if (this.are != null)
         if (this.are.contains(oldGEN_Area))
         {
            this.are.remove(oldGEN_Area);
            oldGEN_Area.setSec((GEN_Sector)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAre() {
      if (are != null)
      {
         GEN_Area oldGEN_Area;
         for (java.util.Iterator iter = getIteratorAre(); iter.hasNext();)
         {
            oldGEN_Area = (GEN_Area)iter.next();
            iter.remove();
            oldGEN_Area.setSec((GEN_Sector)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GEN_Institucion getIns() {
      return ins;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_Institucion */
   public void setIns(GEN_Institucion newGEN_Institucion) {
      if (this.ins == null || !this.ins.equals(newGEN_Institucion))
      {
         if (this.ins != null)
         {
            GEN_Institucion oldGEN_Institucion = this.ins;
            this.ins = null;
            oldGEN_Institucion.removeSec(this);
         }
         if (newGEN_Institucion != null)
         {
            this.ins = newGEN_Institucion;
            this.ins.addSec(this);
         }
      }
   }

}