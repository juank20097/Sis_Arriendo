/***********************************************************************
 * Module:  GEN_ContratoPlantilla_Cab.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_ContratoPlantilla_Cab
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid e716443b-c154-47da-9764-4bb32eb8bcb6 */
public class GEN_ContratoPlantilla_Cab {
   /** @pdOid 5440cc50-e0f0-47ac-8dd8-d56e707a571a */
   private Integer cpc_id;
   /** @pdOid d0ad91c7-83bd-42cd-9bbc-3f0a00c80b9e */
   private String art_tipo;
   /** @pdOid 29f8e735-9fe9-4a63-881b-3a19cff25f74 */
   private String cpc_nombre;
   /** @pdOid 3308ccbe-8c92-4fc0-b436-5edb8693d036 */
   private String cpc_descripcion;
   /** @pdOid bff1cdca-7c1b-4fcc-92e3-d56bb7b8fd2c */
   private Integer cpc_estado;
   
   /** @pdOid d69cd927-6fb7-4a76-aa34-a5fe38245df6 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_ContratoPlantillaClausulas_Det assc=association12 coll=java.util.List mult=* side=A */
   public java.util.List<GEN_ContratoPlantillaClausulas_Det> con_p_d;
   
   /** @pdOid eba15096-3678-435a-8c59-ee25ab7f5997 */
   public GEN_ContratoPlantilla_Cab() {
      // TODO: implement
   }
   
   /** @pdOid 3141fb51-a58e-4dac-bed1-98b69ec2245f */
   public Integer getCpc_id() {
      return cpc_id;
   }
   
   /** @param newCpc_id
    * @pdOid 26eecc0d-71da-47e7-8aae-f1e8851aeaec */
   public void setCpc_id(Integer newCpc_id) {
      cpc_id = newCpc_id;
   }
   
   /** @pdOid 23211f26-1db3-4265-8806-76f81741b58f */
   public String getArt_tipo() {
      return art_tipo;
   }
   
   /** @param newArt_tipo
    * @pdOid 7e6c3131-36de-41aa-8fe0-250a5aa75cfa */
   public void setArt_tipo(String newArt_tipo) {
      art_tipo = newArt_tipo;
   }
   
   /** @pdOid 5b4e1f7e-5a45-4456-9642-ad31ea7793ba */
   public String getCpc_nombre() {
      return cpc_nombre;
   }
   
   /** @param newCpc_nombre
    * @pdOid ca903b08-a583-4d87-8889-23c5d71ca259 */
   public void setCpc_nombre(String newCpc_nombre) {
      cpc_nombre = newCpc_nombre;
   }
   
   /** @pdOid 8c640352-2deb-44cf-bd23-e150ee5267b4 */
   public String getCpc_descripcion() {
      return cpc_descripcion;
   }
   
   /** @param newCpc_descripcion
    * @pdOid 788559ba-f976-4f4c-8e2b-87a892f6abf9 */
   public void setCpc_descripcion(String newCpc_descripcion) {
      cpc_descripcion = newCpc_descripcion;
   }
   
   /** @pdOid aeba00c5-2393-41e1-8d3f-5ea81e40b880 */
   public Integer getCpc_estado() {
      return cpc_estado;
   }
   
   /** @param newCpc_estado
    * @pdOid 46ee46fe-b54d-48cb-94f3-6fa998ef50e5 */
   public void setCpc_estado(Integer newCpc_estado) {
      cpc_estado = newCpc_estado;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GEN_ContratoPlantillaClausulas_Det> getCon_p_d() {
      if (con_p_d == null)
         con_p_d = new java.util.Vector<GEN_ContratoPlantillaClausulas_Det>();
      return con_p_d;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCon_p_d() {
      if (con_p_d == null)
         con_p_d = new java.util.Vector<GEN_ContratoPlantillaClausulas_Det>();
      return con_p_d.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCon_p_d */
   public void setCon_p_d(java.util.List<GEN_ContratoPlantillaClausulas_Det> newCon_p_d) {
      removeAllCon_p_d();
      for (java.util.Iterator iter = newCon_p_d.iterator(); iter.hasNext();)
         addCon_p_d((GEN_ContratoPlantillaClausulas_Det)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGEN_ContratoPlantillaClausulas_Det */
   public void addCon_p_d(GEN_ContratoPlantillaClausulas_Det newGEN_ContratoPlantillaClausulas_Det) {
      if (newGEN_ContratoPlantillaClausulas_Det == null)
         return;
      if (this.con_p_d == null)
         this.con_p_d = new java.util.Vector<GEN_ContratoPlantillaClausulas_Det>();
      if (!this.con_p_d.contains(newGEN_ContratoPlantillaClausulas_Det))
      {
         this.con_p_d.add(newGEN_ContratoPlantillaClausulas_Det);
         newGEN_ContratoPlantillaClausulas_Det.setCon_p_c(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGEN_ContratoPlantillaClausulas_Det */
   public void removeCon_p_d(GEN_ContratoPlantillaClausulas_Det oldGEN_ContratoPlantillaClausulas_Det) {
      if (oldGEN_ContratoPlantillaClausulas_Det == null)
         return;
      if (this.con_p_d != null)
         if (this.con_p_d.contains(oldGEN_ContratoPlantillaClausulas_Det))
         {
            this.con_p_d.remove(oldGEN_ContratoPlantillaClausulas_Det);
            oldGEN_ContratoPlantillaClausulas_Det.setCon_p_c((GEN_ContratoPlantilla_Cab)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCon_p_d() {
      if (con_p_d != null)
      {
         GEN_ContratoPlantillaClausulas_Det oldGEN_ContratoPlantillaClausulas_Det;
         for (java.util.Iterator iter = getIteratorCon_p_d(); iter.hasNext();)
         {
            oldGEN_ContratoPlantillaClausulas_Det = (GEN_ContratoPlantillaClausulas_Det)iter.next();
            iter.remove();
            oldGEN_ContratoPlantillaClausulas_Det.setCon_p_c((GEN_ContratoPlantilla_Cab)null);
         }
      }
   }

}