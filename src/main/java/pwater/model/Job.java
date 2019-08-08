package pwater.model;

import java.util.List;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.Column;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

import lombok.Data;

@Data
@Entity
@Table(name="todo")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "task")
	private String task;

	@Column(name = "category")
	private String categoryId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "create_at")
	private Timestamp createAt;

	@Column(name = "status")
	private Integer status;

}