package org.iamlionheart.phonebook;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PhoneListingDAOImpl implements PhoneListingDAO {
	private PhoneListing alice = new PhoneListing("Alice", "Akins", "555-1111");
	private PhoneListing bob = new PhoneListing("Bob", "Barker", "555-2222");
	
	@Override
	public List<PhoneListing> getAllListings() {
		return Arrays.asList(alice, bob); 
	}

}
