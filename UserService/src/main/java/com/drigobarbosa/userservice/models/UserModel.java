package com.drigobarbosa.userservice.models;

import com.drigobarbosa.userservice.dtos.UserRecordDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_USERS")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID userId;
    private String name;
    private String email;

    public UserModel(UserRecordDto userRecordDto) {
        this.name = userRecordDto.name();
        this.email = userRecordDto.email();
    }

}
