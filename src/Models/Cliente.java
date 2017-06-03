package Models;

import java.util.Date;

public class Cliente {

	protected Date HoraEntrada;
	protected Date HoraSalida;
	protected String precio;

	public Cliente(Date HoraEntrada) {
		super();
		this.HoraEntrada = HoraEntrada;
	}

	public Date getHoraEntrada() {
		return HoraEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		HoraEntrada = horaEntrada;
	}

	public Date getHoraSalida() {
		return HoraSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		HoraSalida = horaSalida;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	

}
