/***********************************************************************
 * Module:  GEN_Sectores.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Sectores
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 9d11dc03-c773-4afa-977a-8d2452c217be */
public class GEN_Sectores {
	/** @pdOid c856cac0-2a99-4616-9af0-fd043ac5e07c */
	private Integer sec_id;
	/** @pdOid 664cdc30-b8aa-4e81-b9e2-887b6cb8e2dd */
	private String sec_nombre;
	/** @pdOid 9916231a-3227-4cb1-af79-f6a0ab3a485f */
	private String sec_direccion;
	/** @pdOid 37d6d1df-036f-4136-8bb9-6b95cd4b7000 */
	private char sec_estado;
	/** @pdOid 451134ab-3506-473f-9573-f12b0d994478 */
	private String sec_ubicacion;

	/** @pdOid d5c63bce-8878-4c31-b8a2-0c53cd8a3ab2 */
	protected void finalize() {
		// TODO: implement
	}

	/**
	 * @pdRoleInfo migr=no name=GEN_Areas assc=association16 coll=java.util.List
	 *             mult=*
	 */
	public java.util.List<GEN_Areas> are;
	/**
	 * @pdRoleInfo migr=no name=GEN_Instituciones assc=association15 mult=1..1
	 *             side=A
	 */
	public GEN_Instituciones ins;

	/** @pdOid 2de0b5b1-b693-4636-83d1-e80aff2ad14f */
	public GEN_Sectores() {
		// TODO: implement
	}

	/** @pdOid 0f9e68d6-4f29-4a10-aab2-10ab2ccff94f */
	public Integer getSec_id() {
		return sec_id;
	}

	/**
	 * @param newSec_id
	 * @pdOid ee51784a-ba7b-4a9f-b287-d2a8216d6872
	 */
	public void setSec_id(Integer newSec_id) {
		sec_id = newSec_id;
	}

	/** @pdOid ff8c8ac1-a141-49c9-a8d4-a61e1350cf52 */
	public String getSec_nombre() {
		return sec_nombre;
	}

	/**
	 * @param newSec_nombre
	 * @pdOid 7d5fe06f-1c54-45f9-bebb-23becfeaf80f
	 */
	public void setSec_nombre(String newSec_nombre) {
		sec_nombre = newSec_nombre;
	}

	/** @pdOid 8f8b024a-6a35-44eb-9560-f796f19ff4e9 */
	public String getSec_direccion() {
		return sec_direccion;
	}

	/**
	 * @param newSec_direccion
	 * @pdOid 8140b6a5-1455-4d68-a1b5-a41c6be9c7be
	 */
	public void setSec_direccion(String newSec_direccion) {
		sec_direccion = newSec_direccion;
	}

	/** @pdOid a8aa5b4a-12fc-450c-88c0-37eec0f33b74 */
	public char getSec_estado() {
		return sec_estado;
	}

	/**
	 * @param newSec_estado
	 * @pdOid 4df03dfb-abcd-4345-8efc-16036c9775d2
	 */
	public void setSec_estado(char newSec_estado) {
		sec_estado = newSec_estado;
	}

	/** @pdOid 5958d782-846d-4124-88f2-df4abf15498b */
	public String getSec_ubicacion() {
		return sec_ubicacion;
	}

	/**
	 * @param newSec_ubicacion
	 * @pdOid c756e5fb-0fa6-4967-a268-e0bf0f42c7fa
	 */
	public void setSec_ubicacion(String newSec_ubicacion) {
		sec_ubicacion = newSec_ubicacion;
	}

	/** @pdGenerated default getter */
	public java.util.List<GEN_Areas> getAre() {
		if (are == null)
			are = new java.util.Vector<GEN_Areas>();
		return are;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorAre() {
		if (are == null)
			are = new java.util.Vector<GEN_Areas>();
		return are.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newAre
	 */
	public void setAre(java.util.List<GEN_Areas> newAre) {
		removeAllAre();
		for (java.util.Iterator iter = newAre.iterator(); iter.hasNext();)
			addAre((GEN_Areas) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newGEN_Areas
	 */
	public void addAre(GEN_Areas newGEN_Areas) {
		if (newGEN_Areas == null)
			return;
		if (this.are == null)
			this.are = new java.util.Vector<GEN_Areas>();
		if (!this.are.contains(newGEN_Areas)) {
			this.are.add(newGEN_Areas);
			newGEN_Areas.setSec(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldGEN_Areas
	 */
	public void removeAre(GEN_Areas oldGEN_Areas) {
		if (oldGEN_Areas == null)
			return;
		if (this.are != null)
			if (this.are.contains(oldGEN_Areas)) {
				this.are.remove(oldGEN_Areas);
				oldGEN_Areas.setSec((GEN_Sectores) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllAre() {
		if (are != null) {
			GEN_Areas oldGEN_Areas;
			for (java.util.Iterator iter = getIteratorAre(); iter.hasNext();) {
				oldGEN_Areas = (GEN_Areas) iter.next();
				iter.remove();
				oldGEN_Areas.setSec((GEN_Sectores) null);
			}
		}
	}

	/** @pdGenerated default parent getter */
	public GEN_Instituciones getIns() {
		return ins;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newGEN_Instituciones
	 */
	public void setIns(GEN_Instituciones newGEN_Instituciones) {
		if (this.ins == null || !this.ins.equals(newGEN_Instituciones)) {
			/*
			 * if (this.ins != null) { System.out.println("2 pasa");
			 * GEN_Instituciones oldGEN_Instituciones = this.ins; this.ins =
			 * null; oldGEN_Instituciones.removeSec(this); }
			 */
			if (newGEN_Instituciones != null) {
				this.ins = newGEN_Instituciones;
				this.ins.addSec(this);
			}
		}
	}

}