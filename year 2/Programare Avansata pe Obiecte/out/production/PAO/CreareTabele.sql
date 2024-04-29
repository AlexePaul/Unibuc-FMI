CREATE TABLE Store (
    StoreId int,
    Address varchar(255),
    PRIMARY KEY (StoreId)
);

CREATE TABLE CoffeMaker(
	ProductId int PRIMARY KEY,
    Price int,
    Name varchar(255),
    WaterTankSize int,
    StoreId int,
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId)
);

CREATE TABLE Fridge(
	ProductId int PRIMARY KEY,
    price int,
    name varchar(255),
    Size int,
    Width int,
    Height int,
    Depth int,
    HasFreezer int,
    StoreId int,
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId)
);

CREATE TABLE Monitor(
	ProductId int PRIMARY KEY,
    price int,
    name varchar(255),
    PixelWidth int,
    PixelHeight int,
    RefreshRate int,
    Size int,
    StoreId int,
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId)
);

CREATE TABLE Peripheral(
	ProductId int PRIMARY KEY,
    price int,
    name varchar(255),
    StoreId int,
    Wireless int,
    Connection varchar(255),
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId)
);

CREATE TABLE PersonalComputer(
	ProductId int PRIMARY KEY,
    price int,
    name varchar(255),
    Ram int,
    Storage int,
    CPU varchar(255),
    GPU varchar(255),
    PSU varchar(255),
    StoreId int,
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId)
);

CREATE TABLE Phone(
	ProductId int PRIMARY KEY,
    price int,
    name varchar(255),
    StoreId int,
    CPU varchar(255),
    ScreenHeight int,
    ScreenWidth int,
    RefreshRate int,
    Storage int,
    Color varchar(255),
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId)
);

CREATE TABLE VacuumCleaner(
	ProductId int PRIMARY KEY,
    price int,
    name varchar(255),
    StoreId int,
    Weight int,
    Color varchar(255),
    Power int,
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId)
);

CREATE TABLE WashingMachine(
	ProductId int PRIMARY KEY,
    price int,
    name varchar(255),
    StoreId int,
    Size int,
    Width int,
    Height int,
    Depth int,
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId)
);