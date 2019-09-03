package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numero;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numero, Date checkIn, Date checkOut) {
		this.numero = numero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = this.checkOut.getTime() - this.checkIn.getTime(); //diferenca em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //conversao em dias
		
	}
	
	public void atualizaDias(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Quarto: ");
		sb.append(this.numero);
		sb.append(", CheckIn: ");
		sb.append(sdf.format(this.checkIn));
		sb.append(", CheckOut: ");
		sb.append(sdf.format(this.checkOut));
		sb.append(", ");
		sb.append(this.duracao());
		sb.append(" noites");
		
		return sb.toString();
	}
}
