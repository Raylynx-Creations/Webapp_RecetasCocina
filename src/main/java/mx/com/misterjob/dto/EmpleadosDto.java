package mx.com.misterjob.dto;

public class EmpleadosDto {
	private Integer idEmpleado;
	private String nombreCompleto;
	private String rfc;
	private String curp;
	private Integer edad;
	private String sexo;
	private String direccion;
	private String nss;
	private Integer telefono; //Bad practice, must be String.
	private Boolean activo;
	
	public EmpleadosDto() {
		super();
	}

	public EmpleadosDto(Integer idEmpleado, String nombreCompleto, String rfc, String curp, Integer edad, String sexo,
			String direccion, String nss, Integer telefono, Boolean activo) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombreCompleto = nombreCompleto;
		this.rfc = rfc;
		this.curp = curp;
		this.edad = edad;
		this.sexo = sexo;
		this.direccion = direccion;
		this.nss = nss;
		this.telefono = telefono;
		this.activo = activo;
	}

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
		return "EmpleadosDto [idEmpleado=" + idEmpleado + ", nombreCompleto=" + nombreCompleto + ", rfc=" + rfc
				+ ", curp=" + curp + ", edad=" + edad + ", sexo=" + sexo + ", direccion=" + direccion + ", nss=" + nss
				+ ", telefono=" + telefono + ", activo=" + activo + "]";
	}
}
