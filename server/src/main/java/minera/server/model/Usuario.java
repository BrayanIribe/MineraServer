package minera.server.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idUsuario;
    public String usuario;
    public String password;
    public String rol;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    public Date createdAt;
}
