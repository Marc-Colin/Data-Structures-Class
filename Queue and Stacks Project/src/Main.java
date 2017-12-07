import java.util.ArrayList;
import java.util.Random;

public class Main
{
	public static Random generator = new Random();
	public static final int NUM_STATIONS = 5;
	public static final int TRAIN_CAPACITY = 50;
	public static final int TRAIN_INTERVAL = 10;
	public static final int TIME_INTERVAL = 200;
	public static int trainCount = 0;
	public static int passengersOnTrains = 0;
	public static int passengersDelivered = 0;

	public static void main(String[] args)
	{
		ArrayList<Station> Stations = new ArrayList<Station>();
		LinkedQueue<Train> Trains = new LinkedQueue<Train>();
		LinkedQueue<Passenger> AllPassengers = new LinkedQueue<Passenger>();
		int TotalPassengers = 0;
		int WaitingPassengers = 0;
		int clock = 0;

		Stations = createStations(Stations);
		for(int timePassed = 0; timePassed < TIME_INTERVAL; timePassed++)
		{
			System.out.println("Time: " + timePassed);
			System.out.println("Waiting Passengers: " + WaitingPassengers);
			System.out.println("Passengers on a Train: " + passengersOnTrains);
			createTrain(Trains, timePassed);
			WaitingPassengers = TotalPassengers - passengersOnTrains - passengersDelivered;
			TotalPassengers += createPassengers(Stations, AllPassengers);
			moveTrain(Trains, Stations, timePassed);
			clock = timePassed;
		}
		finalReport(clock, TotalPassengers, AllPassengers);
	}

	public static ArrayList<Station> createStations(ArrayList<Station> Stations)
	{
		for(int i = 0; i < NUM_STATIONS; i++)
		{
			Stations.add(new Station(generator.nextInt(10) + 5));
			System.out.println("Station " + i + "time to next " + Stations.get(i).getTimeToNextStation());
		}
		return Stations;
	}

	public static LinkedQueue<Train> createTrain(LinkedQueue<Train> Trains, int timePassed)
	{
		if((TIME_INTERVAL - timePassed) % TRAIN_INTERVAL == 0)
		{
			Trains.enqueue(new Train(TRAIN_CAPACITY));
			trainCount++;
		}
		return Trains;
	}

	public static int createPassengers(ArrayList<Station> Stations, LinkedQueue<Passenger> AllPassengers)
	{
		int newPassengers = generator.nextInt(6);
		int startStation = 0;
		int stopStation = 0;
		Passenger tempPassenger;
		for(int i = 0; i < newPassengers; i++)
		{
			startStation = 4;
			stopStation = 0;
			while(startStation >= stopStation)
			{
				startStation = generator.nextInt(NUM_STATIONS);
				stopStation = generator.nextInt(NUM_STATIONS);
			}
			tempPassenger = new Passenger(startStation, stopStation);
			AllPassengers.enqueue(tempPassenger);
			Stations.get(startStation).addPassenger(tempPassenger);
		}
		return newPassengers;
	}

	public static void moveTrain(LinkedQueue<Train> Trains, ArrayList<Station> Stations, int timePassed)
	{
		int numTrains = trainCount;
		int timeNext = 0;
		int currentStation = 0;
		int getOff;
		int getOn;
		for(int i = 0; i < numTrains; i++)
		{
			Train currentTrain = Trains.dequeue();
			currentTrain.move();
			timeNext = currentTrain.timeToNext();
			if(timeNext == 0)
			{
				currentStation = currentTrain.nextStation();
				getOff = currentTrain.unloadPassengers(currentStation);
				getOn = currentTrain.loadPassengers(Stations.get(currentStation), timePassed);
				passengersOnTrains += getOn;
				passengersOnTrains -= getOff;
				passengersDelivered += getOff;
				currentTrain.updateStation(Stations.get(currentStation).getTimeToNextStation());
			}
			if(currentTrain.nextStation() < NUM_STATIONS)
			{
				Trains.enqueue(currentTrain);
			}
			else
			{
				trainCount--;
			}
		}
	}

	/** Reports the final situations of the trains and passengers waiting
	and some statistics for passengers' wait times.
	@param clock The time that train operations have ceased. */
	public static void finalReport(int clock, int passengersCreated, QueueInterface<Passenger> passengers)
	{
		System.out.println("Final Report");
		System.out.println("The total number of passengers is " + passengersCreated);
		System.out.println("The number of passengers currently on a train " + passengersOnTrains );
		System.out.println("The number of passengers delivered is " + passengersDelivered);

		int waitBoardedSum = 0;
		int waitNotBoardedSum = 0;

		for (int i=0; i < passengersCreated; i++)
		{
			Passenger p = passengers.dequeue();
			if(p.boarded())
				waitBoardedSum += p.waitTime(clock);
			else
				waitNotBoardedSum += p.waitTime(clock);
		} // end for

		System.out.println("The average wait time for passengers " + "that have boarded is");
		System.out.println((double)waitBoardedSum/(passengersOnTrains + passengersDelivered));
		System.out.println("The average wait time for passengers " + "that have not yet boarded is");
		System.out.println((double)waitNotBoardedSum / (passengersCreated - passengersOnTrains -passengersDelivered));
	} // end finalReport
}
