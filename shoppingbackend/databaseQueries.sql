CREATE TABLE CATEGORY (

	c_id IDENTITY,
	c_name VARCHAR(50),
	c_description VARCHAR(500),
	c_thumbnail_url VARCHAR(1000),
	c_is_active BOOLEAN,
	
	CONSTRAINT PK_CATEGORY_ID PRIMARY KEY (c_id)

);

INSERT INTO CATEGORY(c_name, c_thumbnail_url, c_description, c_is_active) 
VALUES ('Mobiles', 'mobiles.png', 'Whether it''s to stay connected with friends and family or to keep abreast of important developments around the world, mobiles are no longer for sending a text or making a call. From budget to state-of-the-art smartphones, indigenous names to global big-wigs - a whole universe of mobiles await you', true);

INSERT INTO CATEGORY(c_name, c_thumbnail_url, c_description, c_is_active) 
VALUES ('Television', 'television.png', 'Buy Smart TV at India''s Best Online Shopping Store. Choose from a huge range of smart led TV from brands like VU, Samsung, Sony & more', true);

INSERT INTO CATEGORY(c_name, c_thumbnail_url, c_description, c_is_active) 
VALUES ('Watches', 'watches.png', 'Watches Store - Buy Stylish & Designer Watches for Mens & Ladies Online at Best Prices in India.', true);

INSERT INTO CATEGORY(c_name, c_thumbnail_url, c_description, c_is_active) 
VALUES ('Video Games', 'videogame.png', 'E-Kart offers you a range of options, from consoles like PlayStation PS4 Games and Xbox to building your personal gaming rig. If youre looking to invest quality time in this hobby, you may browse for gaming console like gaming mice, gaming headsets, gaming keyboards and more', true);

CREATE TABLE USER_DETAILS (
	
	ud_Id IDENTITY,
	ud_first_name VARCHAR(50),
	ud_last_name VARCHAR(50),
	ud_role VARCHAR(50),
	ud_enabled BOOLEAN,
	ud_password VARCHAR(50),
	ud_email_address VARCHAR(100),
	ud_phone_number VARCHAR(15),
	
	CONSTRAINT PK_USER_DETAILS_ID PRIMARY KEY (ud_Id)	

);

INSERT INTO USER_DETAILS(ud_first_name, ud_last_name, ud_role, ud_enabled, ud_password, ud_email_address, ud_phone_number)
VALUES ('Anand', 'A', 'ADMIN', true, '********', 'asd@gmail.com', '9876543210');

INSERT INTO USER_DETAILS(ud_first_name, ud_last_name, ud_role, ud_enabled, ud_password, ud_email_address, ud_phone_number)
VALUES ('Supplier', 'One', 'SUPPLIER', true, 'password', 'abc@gmail.com', '0123456789');

INSERT INTO USER_DETAILS(ud_first_name, ud_last_name, ud_role, ud_enabled, ud_password, ud_email_address, ud_phone_number)
VALUES ('Supplier', 'Two', 'SUPPLIER', true, 'password', 'xyz@gmail.com', '3218976540');

CREATE TABLE PRODUCT (

	p_id IDENTITY,
	p_code VARCHAR(20),
	p_name VARCHAR(100),
	p_specs VARCHAR(2000),
	p_brand VARCHAR(20),
	p_description CLOB,
	p_unit_price DECIMAL(10,2),
	p_quantity INT,
	p_is_active BOOLEAN,
	p_category_id INT,
	p_supplier_id INT,
	p_purchases INT DEFAULT 0,
	p_views INT DEFAULT 0,
	p_rating1 INT DEFAULT 0,
	p_rating2 INT DEFAULT 0,
	p_rating3 INT DEFAULT 0,
	p_rating4 INT DEFAULT 0,
	p_rating5 INT DEFAULT 0,
	p_portrait_url VARCHAR(1000),
	p_wallpaper_url VARCHAR(1000),
	
	CONSTRAINT PK_PRODUCT_ID PRIMARY KEY (p_id),
	CONSTRAINT FK_PRODUCT_CATEGORY_ID FOREIGN KEY (p_category_id) REFERENCES CATEGORY (c_id),
	CONSTRAINT FK_PRODUCT_SUPPLIER_ID FOREIGN KEY (p_supplier_id) REFERENCES USER_DETAILS (ud_Id)
	
);

/* Mobile Products*/
INSERT INTO PRODUCT(p_code, p_name, p_specs, p_brand, p_description, p_unit_price, p_quantity, p_is_active, p_category_id, p_supplier_id, p_portrait_url, p_wallpaper_url)
VALUES ('PRDOP7P53999', 'OnePlus 7T PRO', 'Haze Blue, 8GB RAM, Fluid AMOLED Display, 256GB Storage, 4085mAH Battery',
		'One Plus', 'The all new OnePlus 7T Pro Powered by Qualcomm Snapdragon 855 Plus (Octa-core, 7nm, up to 2.96 GHz) with Qualcomm AI Engine. Equipped with 90hz Fluid display, a Triple Rear camera with Telephoto and Ultra wide angel lens, that can capture 4K video @ 30/60 FPS with modes like UltraShot, Nightscape, Portrait, Pro Mode, Panorama, HDR, AI Scene Detection, RAW Image. Face Unlock, HDR, Screen Flash, Face Retouching, In-built - Fingerprint.',
		53999.00, 100, true, 1, 2, 'op7t1.png', 'op7t2.png');
		
INSERT INTO PRODUCT(p_code, p_name, p_specs, p_brand, p_description, p_unit_price, p_quantity, p_is_active, p_category_id, p_supplier_id, p_portrait_url, p_wallpaper_url)
VALUES ('PRDOP729999', 'OnePlus 7', 'Mirror Grey, 6GB RAM, Optic AMOLED Display, 128GB Storage, 3700mAH Battery',
		'One Plus', 'Go beyond speed with OnePlus 7 packed with Snapdragon 855, an immersive Full HD display, an industry leading dual camera and premium glass design',
		29999.00, 100, true, 1, 2, 'op71.png', 'op72.png');
		
INSERT INTO PRODUCT(p_code, p_name, p_specs, p_brand, p_description, p_unit_price, p_quantity, p_is_active, p_category_id, p_supplier_id, p_portrait_url, p_wallpaper_url)
VALUES ('PRDSM3016999', 'Samsung Galaxy M30s', 'Sapphire Blue, 6GB RAM, Super AMOLED Display, 128GB Storage, 6000mAH Battery',
		'Samsung', 'With the Samsung Galaxy M30s, Samsung introduces a 6000 mAh battery for the first time in this price segment- along with all round features comprising of a 48 MP rear camera in triple camera set up and an immersive sAmoled screen. This Device which comes in the color Sapphire Blue is described on the Box as “Blue”',
		16999.00, 100, true, 1, 3, 'm301.png', 'm302.png');
		
INSERT INTO PRODUCT(p_code, p_name, p_specs, p_brand, p_description, p_unit_price, p_quantity, p_is_active, p_category_id, p_supplier_id, p_portrait_url, p_wallpaper_url)
VALUES ('PRDSMG1016999', 'Samsung Galaxy Note 10+', 'Aura White, 12GB RAM, 256GB Storage',
		'Samsung', 'Introducing next-level power. With Galaxy Note10 and Note10+ we''ve designed a mobile experience that’s like a computer, a gaming console, a movie-tech camera, and an intelligent pen, all in one device.',
		79999.00, 100, true, 1, 3, 's10plus1.png', 's10plus2.png');
		
INSERT INTO PRODUCT(p_code, p_name, p_specs, p_brand, p_description, p_unit_price, p_quantity, p_is_active, p_category_id, p_supplier_id, p_portrait_url, p_wallpaper_url)
VALUES ('PRDV17P29990', 'Vivo V17 Pro', 'Midnight Ocean, 8GB RAM, 128GB Storage',
		'Vivo', 'The Vivo V17 pro smartphone is equipped with 32MP+8MP (Dual Pop-Up) Selfie camera, AI quad rear camera 48MP +13MP+8MP+2MP with Sony sensor, a 4,100mAh battery with 18W dual-engine fast charging technology, in-display fingerprint, 16.36cm (6.44) sAMOLED FHD+ display, 8GB RAM, 128GB internal memory and much more.',
		29990.00, 100, true, 1, 3, 'vv171.png', 'vv172.png');
		
/* Television Products*/
INSERT INTO PRODUCT(p_code, p_name, p_specs, p_brand, p_description, p_unit_price, p_quantity, p_is_active, p_category_id, p_supplier_id, p_portrait_url, p_wallpaper_url)
VALUES ('PRDSGQAAKXXL', 'Samsung QA65Q60RAKXXL', '163 cm (65 Inches) 4K Ultra HD Smart QLED TV (Black) 2019 Model',
		'Samsung', 'Experience superior picture and sound quality created for Indian viewers in 4K resolution. Superior Sleek TV enhances the look of your living Room . A Smart TV – watch videos, play music or view photos through a USB connection ,through Internet or via your Samsung Phone',
		186999.99, 20, true, 2, 2, 'tv1.png', 'tv2.png');
		