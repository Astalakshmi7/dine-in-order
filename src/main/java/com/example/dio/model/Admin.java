package com.example.dio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Admins")
public class Admin extends User{
}
