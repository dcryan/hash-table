import java.lang.Integer;

public class hashTableClient
{
	private static class HashTable
	{
		Integer[] values;
		int size;


		public HashTable (int size)
		{
			this.values = new Integer[size];
			this.size = 0;
		}

		private int hashFunction( int value )
		{
			return value % values.length;
		}

		public void insert( int value ) throws Exception
		{
			if(size >= values.length) throw new Exception("can't add value: " + value);

			int hashKey = hashFunction(value);

			while( values[hashKey] != null ) hashKey = (hashKey + 1) % values.length;

			values[hashKey] = new Integer(value);

			size ++;
		}

		public String toString()
		{
			System.out.print("|");
			for(int i = 0 ; i < values.length ; i++)
			{
				if( values[i] != null)
					System.out.print(values[i] + "|");
				else
					System.out.print(" |");
			}
			System.out.println();

			return "";
		}
	}


	public static void main(String[] args)
	{
		HashTable ht = new HashTable(10);
		try
		{
			ht.insert(1);
			ht.insert(1);
			ht.insert(1);
			ht.insert(1);
			ht.insert(1);
			ht.insert(1);
			ht.insert(1);
			ht.insert(3);
			ht.insert(3);
			ht.insert(3);
			ht.insert(3);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println(ht);
		}
	}
}



