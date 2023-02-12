package hu.lj.kod.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "change_rate")
@Data
@EqualsAndHashCode
public class ChangeRate {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "symbol_from")
	private Long symbolFrom;
	
	@ManyToOne()
	@JoinColumn(name = "symbol_from", updatable = false, insertable = false)
	private Symbol symbolFromEntity;
	
	@Column(name = "symbol_to")
	private Long symbolTo;
	
	@ManyToOne
	@JoinColumn(name = "symbol_to", updatable = false, insertable = false)
	private Symbol symbolToEntity;
	
	@Column(name = "changeRate")
	private Long changeRate;
	

}
