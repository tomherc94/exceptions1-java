package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("\nNumero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("\nCheckIn (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("\nCheckOut (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.print("Reserva: " + reserva);

			System.out.println("\nNovas datas de reversa: \n");
			System.out.print("\nCheckIn (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("\nCheckOut (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reserva.atualizaDias(checkIn, checkOut);
			System.out.print("Reserva: " + reserva);
		} 
		catch (ParseException e) {
			System.out.println("Data invalida!");
		}
		catch(DomainException e) {
			System.out.println("Erro de reserva! " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();

	}

}
