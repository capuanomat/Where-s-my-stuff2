//
//  Model.swift
//  Where's My Stuff
//
//  Created by Ash Bhimasani on 7/18/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import UIKit
import Firebase
import FirebaseDatabase

let model = Model()

class Model: NSObject {
    private var currentUser: User
    private var userList: [User]
    private var lostList: [LostItem]
    private var foundList: [FoundItem]
    private let lostRef = Database.database().reference(withPath: "lost-items")
    private let foundRef = Database.database().reference(withPath: "found-items")
    
    override init() {
        self.currentUser = User(username: "", password: "")
        self.userList = []
        self.lostList = []
        self.foundList = []
        
        super.init()
    }
    
    //User Functions
    func setCurrentUser(user: User) -> Void {
        self.currentUser = user
    }
    func getCurrentUser() -> User {
        return self.currentUser
    }
    func getUserList() -> [User] {
        return userList
    }
    func addUser(user: User) -> Void {
        userList.append(user)
    }
    
    
    //Item Functions
    func addLost(lostIt: LostItem) -> Void {
        let itemRef = lostRef.childByAutoId()
        itemRef.setValue(lostIt.toAnyObject())
        lostList.append(lostIt)
        
    }
    func updateLost() -> Void {
        lostRef.observe(.value, with: { snapshot in
            // 2
            print(snapshot.value!)
            var newItems: [LostItem] = []
            // 3
            for item in snapshot.children {
                // 4
                let lostItem = LostItem(snapshot: item as! DataSnapshot)
                newItems.append(lostItem)
            }
            print(newItems)
            // 5
            self.lostList = newItems
        })
    }
    func getLost() -> [LostItem] {
        return self.lostList
    }
    func addFound(foundIt: FoundItem) -> Void {
        let itemRef = foundRef.childByAutoId()
        itemRef.setValue(foundIt.toAnyObject())
        foundList.append(foundIt)
    }
    func updateFound() -> Void {
        foundRef.observe(.value, with: { snapshot in
            // 2
            print(snapshot.value!)
            var newItems: [FoundItem] = []
            // 3
            for item in snapshot.children {
                // 4
                let foundItem = FoundItem(snapshot: item as! DataSnapshot)
                newItems.append(foundItem)
            }
            // 5
            self.foundList = newItems
        })
    }
    func getFound() -> [FoundItem] {
        return self.foundList
    }
    
    
    //Login & Register Functionality
    func login(user: User) -> Bool {
        for item in userList {
            if (item.getUserName() == user.getUserName()) {
                if (item.getPassword() == user.getPassword()) {
                    model.setCurrentUser(user: item)
                    return true
                }
            }
        }
        return false
    }
    func register(user: User) -> Bool {
        for item in userList {
            if (item.getUserName() == user.getUserName()) {
                return false
            }
        }
        model.addUser(user: user)
        model.setCurrentUser(user: user)
        return true
    }
    
}
