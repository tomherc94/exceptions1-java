package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("\nNumero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("\nCheckIn (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("\nCheckOut (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (checkOut.before(checkIn)) {
			System.out.println("Erro! Data de saida anterior a data de entrada!");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.print("Reserva: " + reserva);

			System.out.println("\nNovas datas de reversa: \n");
			System.out.print("\nCheckIn (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("\nCheckOut (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();

			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("\nErro de reserva. As datas para atualizacao devem ser futuras!");
			} else if (checkOut.before(checkIn)) {
				System.out.println("Erro! Data de saida anterior a data de entrada!");
			} else {
				reserva.atualizaDias(checkIn, checkOut);
				System.out.print("Reserva: " + reserva);
			}

		}

		sc.close();

	}

}
