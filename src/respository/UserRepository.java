package respository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import modelos.User;

public class UserRepository {

	private final String FILE = "src/files/users.csv";
	
	public void save(User user) throws IOException
	{
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE, true))))
		{
			writer.write(user.toCsv());
			writer.newLine();
		}
	
	}

	public List<User> getUsers() throws IOException
	{
		List<User> users = new ArrayList<User>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(FILE)))
		{
			String line;
			
			while((line = reader.readLine()) != null)
			{
				User user = User.fromCsv(line);
				users.add(user);
			}
		}
		
		return users;
	}
	public List<User> updateAll(List<User> users) throws IOException
	{
		
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE), StandardCharsets.UTF_8)))
		
		{
			
			
			for(User user : users) {
				writer.write(user.toCsv());
				writer.newLine();
			}
		}
		
		return users;
	}
	public void delete(int index) throws IOException {
		List<User> users = getUsers();
		users.remove(index);
		updateAll(users);
	}
	public void update(int index, User updatedUser) throws IOException {
		List<User> users = getUsers();
		users.set(index, updatedUser);
		updateAll(users);
	}
}
