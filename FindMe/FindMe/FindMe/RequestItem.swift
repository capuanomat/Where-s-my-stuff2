//
//  RequestItem.swift
//  FindMe
//
//  Created by Ash Bhimasani on 7/25/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import Foundation
import Firebase
import FirebaseDatabase

class RequestItem {
    private var username: String
    private var itemName: String
    private var longitude: Double
    private var latitude: Double
    
    init(user: User, itemName: String, latitude: Double, longitude: Double) {
        self.username = user.getUserName()
        self.itemName = itemName
        self.longitude = longitude
        self.latitude = latitude
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
    
    init(snapshot: DataSnapshot) {
        let snapshotValue = snapshot.value as! [String: AnyObject]
        username = snapshotValue["user"] as! String
        itemName = snapshotValue["itemName"] as! String
        latitude = snapshotValue["latitude"] as! Double
        longitude = snapshotValue["longitude"] as! Double
    }
    
    func toAnyObject() -> Any {
        return [
            "user": username,
            "itemName": itemName,
            "latitude": latitude,
            "longitude": longitude
        ]
    }
    
}
