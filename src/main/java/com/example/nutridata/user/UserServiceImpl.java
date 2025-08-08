package com.example.nutridata.user;

import com.example.nutridata.user.dto.UserRequest;
import com.example.nutridata.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return userRepository
                .findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = new User();

        user.setName(userRequest.name());
        user.setLastName(userRequest.lastName());
        user.setEmail(userRequest.email());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setPassword(userRequest.password());
        user.setOccupation(userRequest.occupation());

        return mapToResponse(userRepository.save(user));
    }

    @Override
    public UserResponse updateUserById(Long id, UserRequest userRequest) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userRequest.name());
        user.setLastName(userRequest.lastName());
        user.setEmail(userRequest.email());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setPassword(userRequest.password());
        user.setOccupation(userRequest.occupation());

        return mapToResponse(userRepository.save(user));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getOccupation(),
                user.getActive(),
                user.getCreatedAt(),
                user.getUpdatedAt());
    }

}
