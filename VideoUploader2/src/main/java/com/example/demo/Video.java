package com.example.demo;

	import jakarta.persistence.*;

	@Entity
	@Table(name = "videos")
	public class Video {
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String type;

	    @Lob
	    @Column(columnDefinition = "LONGBLOB")
	    private byte[] data;

		public Video(Long id, String name, String type, byte[] data) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.data = data;
		}

		public Video() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

	    
	}
