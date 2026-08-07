package com.example.lab7_673380391_3_sec3.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private String platform;
    private Double price;
    private Double rating;
    
    @Column(name = "release_date")
    private LocalDate releaseDate;
    
    @Column(name = "discount_type")
    private String discountType;

    // เพิ่มฟิลด์เหล่านี้เพื่อให้ตรงกับที่ GameService เรียกใช้
    @Transient // ใช้ @Transient เพื่อไม่ให้บันทึกฟิลด์คำนวณลงฐานข้อมูล (หรือลบออกถ้าอาจารย์ต้องการให้เซฟลง DB ด้วย)
    private Double finalPrice;
    
    @Transient
    private String discountName;

    public Game() {
    }

    // ==========================================
    // 📦 Getter & Setter มาตรฐานทั้งหมด
    // ==========================================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public String getDiscountType() { return discountType; }
    public void setDiscountType(String discountType) { this.discountType = discountType; }

    // Getter & Setter สำหรับ finalPrice
    public Double getFinalPrice() { 
        return finalPrice != null ? finalPrice : price; 
    }
    public void setFinalPrice(Double finalPrice) { 
        this.finalPrice = finalPrice; 
    }

    // Getter & Setter สำหรับ discountName
    public String getDiscountName() { 
        return discountName != null ? discountName : "ราคาปกติ"; 
    }
    public void setDiscountName(String discountName) { 
        this.discountName = discountName; 
    }
}