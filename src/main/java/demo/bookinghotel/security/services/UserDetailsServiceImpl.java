package demo.bookinghotel.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.bookinghotel.models.customer;
import demo.bookinghotel.repository.customerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    customerRepository customerRepository;

    @Transactional
    public UserDetails customerByName(String name) throws UsernameNotFoundException {
        customer customer = customerRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("customer Not Found with name: " + name));

        return UserDetailsImpl.build(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }
}
