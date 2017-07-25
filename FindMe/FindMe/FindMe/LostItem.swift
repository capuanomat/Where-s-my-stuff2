//
//  LostItem.swift
//  Where's My Stuff
//
//  Created by Ash Bhimasani on 7/19/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import Foundation
import Firebase
import FirebaseDatabase

class LostItem {
    private var username: String
    private var itemName: String
    private var descrip: String
    private var lostDate: String
    private var longitude: Double
    private var latitude: Double
    private var reward: String = "0"

    init(user: User, itemName: String, latitude: Double, longitude: Double, descrip: String, lostDate: String, reward: String) {
        self.username = user.getUserName()
        self.itemName = itemName
        self.longitude = longitude
        self.latitude = latitude
        self.descrip = descrip
        self.lostDate = lostDate
        self.reward = reward

    }
    
    func getUserName() -> String {
        return self.username
    }
    func getName() -> String {
        return self.itemName
    }
    func getLongitude() -> Double {
        return self.longitude
    }
    func getLatitude() -> Double {
        return self.latitude
    }
    func getDescrip() -> String {
        return self.descrip
    }
    func getDate() -> String {
        return self.lostDate
    }
    func getReward()-> String {
        return self.reward
    }
    
    init(snapshot: DataSnapshot) {
        let snapshotValue = snapshot.value as! [String: AnyObject]
        print(snapshotValue["user"])
        print(snapshotValue["itemName"])
        username = snapshotValue["user"] as! String
        itemName = snapshotValue["itemName"] as! String
        latitude = snapshotValue["latitude"] as! Double
        longitude = snapshotValue["longitude"] as! Double
        descrip = snapshotValue["descrip"] as! String
        lostDate = snapshotValue["lostDate"] as! String
        reward = snapshotValue["reward"] as! String
    }
    
    func toAnyObject() -> Any {
        return [
            "user": username,
            "itemName": itemName,
            "latitude": latitude,
            "longitude": longitude,
            "descrip": descrip,
            "lostDate": lostDate,
            "reward": reward
        ]
    }
    
}
