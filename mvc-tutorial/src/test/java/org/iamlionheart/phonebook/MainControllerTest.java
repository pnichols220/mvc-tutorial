package org.iamlionheart.phonebook;

import static org.junit.Assert.*; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
	
	private PhoneListing alice = new PhoneListing("Alice", "Akins", "555-1111");
	private PhoneListing bob = new PhoneListing("Bob", "Barker", "555-2222");

	@Mock
	private PhoneListingDAO dao;
	
	@Mock
	private ModelMap modelMap;
	
	@Captor
	private ArgumentCaptor<List<PhoneListing>> listingCaptor; 
	
	@InjectMocks
	private MainController mc = new MainController();
	
	@Before
	public void setUp() {
		when(dao.getAllListings()).thenReturn(Collections.singletonList(alice));
	}
	
	@Test
	public void testShowFullListing() {
		String view = mc.showFullListing(modelMap);
		
		assertEquals("listing", view);
		
		verify(dao).getAllListings();
		verify(modelMap).addAttribute("phonebook", listingCaptor.capture());
		
		List<PhoneListing> listing = listingCaptor.getValue();
		
		assertEquals(1, listing.size());
		assertSame(alice, listing.get(0));
		
				
	}

}
