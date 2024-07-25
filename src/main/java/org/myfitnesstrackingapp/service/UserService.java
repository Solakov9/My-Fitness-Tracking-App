package org.myfitnesstrackingapp.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.myfitnesstrackingapp.model.entity.User;
import org.myfitnesstrackingapp.model.entity.Workout;
import org.myfitnesstrackingapp.model.entity.dto.AddWorkoutDTO;
import org.myfitnesstrackingapp.model.entity.dto.UserRegisterDTO;
import org.myfitnesstrackingapp.repo.UserRepository;
import org.myfitnesstrackingapp.repo.WorkoutRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final WorkoutRepository workoutRepository;

    public void register(UserRegisterDTO userRegisterDTO) {
        User user = this.modelMapper.map(userRegisterDTO, User.class);

        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(user);
    }
    public User getCurrentUserData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName()).get();
    }

    public void saveWorkout(AddWorkoutDTO data) {
        Workout workout = new Workout();
        User currentUser = this.getCurrentUserData();
        workout.setName(data.getName());
        workout.setCategory(data.getCategory());
        workout.setLevel(data.getLevel());
        workout.setAddedBy(currentUser);
        workout.setExercises(data.getExercises());
        workout.setNumberOfSelections(0);
        workout.setLikes(0);
        workoutRepository.save(workout);
    }
}
