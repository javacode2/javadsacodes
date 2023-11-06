
class linearsearch{
	public static int linear(int arr[], int x)
	{
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		int arr[] = { 12, 114, 0, 4, 9 };
		int search = linear(arr,4); 
		System.out.println(search);
	}
}


