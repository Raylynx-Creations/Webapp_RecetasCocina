package mx.com.misterjob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADOS", schema="ADMIN_RECETAS_WEBSITE")
public class EmpleadosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
    @SequenceGenerator(
        name = "user_sequence_generator", 
        sequenceName = "SEQ_EMP", 
        allocationSize = 1
    )
	@Column(name = "ID_EMPLEADO")
	private Integer idEmpleado;
	
	@Column(name = "NOMBRE_COMPLETO")
	private String nombreCompleto;
	
	@Column(name = "RFC")
	private String rfc;
	
	@Column(name = "CURP")
	private String curp;
	
	@Column(name = "EDAD")
	private Integer edad;
	
	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "NSS")
	private String nss;
	
	@Column(name = "TELEFONO")
	private Integer telefono; //This should be a String, it's a bad practice.
	
	@Column(name = "ACTIVO")
	private Boolean activo;

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "EmpleadosEntity [idEmpleado=" + idEmpleado + ", nombreCompleto=" + nombreCompleto + ", rfc=" + rfc
				+ ", curp=" + curp + ", edad=" + edad + ", sexo=" + sexo + ", direccion=" + direccion + ", nss=" + nss
				+ ", telefono=" + telefono + ", activo=" + activo + "]";
	}
}
