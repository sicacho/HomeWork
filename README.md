# HomeWork
To optimize of reading speed . We will load whole Json file to memory and build a in memory Doucment Database to store Data by HashMap<Key,Value> java .

Ex : 

With Json Object Below

  {
    "vn": 4,
    "sg": 4,
    "tw": 4,
    "hk": 4,
    "my": 128,
    "ph": 4,
    "th": null
  }
  
We will have 6 Document in Database .

  {"vn-4" :  {"vn": 4,"sg": 4,"tw": 4,"hk": 4,"my": 128,"ph": 4,"th": null} }
  
  {"sg-4" :  {"vn": 4,"sg": 4,"tw": 4,"hk": 4,"my": 128,"ph": 4,"th": null} }
  
  {"hk-4" :  {"vn": 4,"sg": 4,"tw": 4,"hk": 4,"my": 128,"ph": 4,"th": null} }
  
  {"my-128" :  {"vn": 4,"sg": 4,"tw": 4,"hk": 4,"my": 128,"ph": 4,"th": null} }
  
  {"th-4" :  {"vn": 4,"sg": 4,"tw": 4,"hk": 4,"my": 128,"ph": 4,"th": null} }
  
  {"tw-4" :  {"vn": 4,"sg": 4,"tw": 4,"hk": 4,"my": 128,"ph": 4,"th": null} }
