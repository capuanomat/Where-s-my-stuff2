//
//  FoundListViewController.swift
//  Where's My Stuff
//
//  Created by Ash Bhimasani on 7/22/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import Foundation

import UIKit

class ListCellController2: UITableViewCell {
    
    @IBOutlet weak var itemName: UILabel!
    @IBOutlet weak var itemDescrip: UILabel!
    @IBOutlet weak var itemDate: UILabel!
    @IBOutlet weak var itemStatus: UILabel!
}

class FoundListViewController: UIViewController {
    
    @IBOutlet weak var listTable: UITableView!
    
    @IBAction func backButton(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    var itemList: [FoundItem] = []
    
    var filteredSearch: [FoundItem] = []
    
    let searchController = UISearchController(searchResultsController: nil)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = UIColor(red:0.99, green:0.66, blue:0.69, alpha:1.0)
        //        listTable.tableFooterView = UIView()
        listTable.backgroundColor = UIColor(red:0.99, green:0.66, blue:0.69, alpha:1.0)
        
        searchController.searchResultsUpdater = self as UISearchResultsUpdating
        searchController.dimsBackgroundDuringPresentation = false
        
        searchController.searchBar.placeholder = "Search here..."
        searchController.searchBar.backgroundImage = UIImage(named: "white")
        searchController.searchBar.setTextColor(color: UIColor(red:0.99, green:0.66, blue:0.69, alpha:1.0))
        searchController.searchBar.setPlaceholderTextColor(color: UIColor(red:0.99, green:0.66, blue:0.69, alpha:1.0))
        searchController.searchBar.setTextFieldColor(color: .white)
        
        definesPresentationContext = true
        listTable.tableHeaderView = searchController.searchBar
        
        itemList = model.getFound()
    }
    
    func filterContentforSearchText(searchText: String) {
        
        print("jiggly")
        print(searchText)
        
        
        filteredSearch = itemList.filter {
            $0.getName().lowercased().contains(searchText.lowercased())
        }
        
        print(filteredSearch)
        
        listTable.reloadData()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}

extension FoundListViewController: UITableViewDataSource, UITableViewDelegate, UISearchResultsUpdating {
    
    func updateSearchResults(for searchController: UISearchController) {
        filterContentforSearchText(searchText: searchController.searchBar.text!)
    }
    
    func tableView(_ listTable: UITableView, numberOfRowsInSection section: Int) -> Int {
        //Runs loop until the data is loaded from the api
        if searchController.isActive && searchController.searchBar.text != "" {
            return filteredSearch.count
        }
        return itemList.count
        
    }
    
    func tableView(_ listTable: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        //Dequeueing array of default tickers to populate cells in table
        let cell = listTable.dequeueReusableCell(withIdentifier: "listCell2", for: indexPath) as! ListCellController2
        
        //setting background color of cell
        cell.backgroundColor = UIColor(red:0.99, green:0.66, blue:0.69, alpha:1.0)
        
        if searchController.isActive && searchController.searchBar.text != "" {
            let display = filteredSearch[indexPath.row]
            cell.itemName.text = display.getName()
            cell.itemDescrip.text = display.getDescrip()
            cell.itemDate.text = display.getDate()
            cell.itemStatus.text = "Found"
            cell.itemName.textColor = .white
            //            cell.itemDescrip.textColor = .white
            cell.itemDate.textColor = .white
            cell.itemStatus.textColor = .white
        } else {
            let display = itemList[indexPath.row]
            cell.itemName.text = display.getName()
            cell.itemDescrip.text = display.getDescrip()
            cell.itemDate.text = display.getDate()
            cell.itemStatus.text = "Found"
            cell.itemName.textColor = .white
            //            cell.itemDescrip.textColor = .white
            cell.itemDate.textColor = .white
            cell.itemStatus.textColor = .white
        }
        
        //returning populated cell to tickerTable
        return cell
        
    }
    
    
    
}
