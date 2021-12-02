<%@page language="java" import = "java.util.*, java.awt.*, entity.*, dao.*"%>
<%
    String s = (String)request.getParameter("btn");
    if(s.equals("Add Laptop")){ 
        String check = "";
        int idProducer = 0;
        String nameLaptop = "";
        String type = "";
        int price = 0;
        float size = 0;
        String cpu = "";
        int ram = 0;
        int count = 0;
        String arr[] = {"idProducer", "nameLaptop", "type", "price", "size", "cpu", "ram"};
        for(int i=0; i<7; i++){
            check = (String)request.getParameter(arr[i]);
            if(!check.equals(""))
                count++;
        }
        
        if(count == 7){
            idProducer = Integer.parseInt(request.getParameter("idProducer"));
            nameLaptop = (String)request.getParameter("nameLaptop");
            type = (String)request.getParameter("type");
            price = Integer.parseInt(request.getParameter("price"));
            size = Float.parseFloat(request.getParameter("size"));
            cpu = (String)request.getParameter("cpu");
            ram = Integer.parseInt(request.getParameter("ram"));

            Laptop laptop = new Laptop(idProducer, nameLaptop, type, price, size, cpu, ram);
            LaptopDAO lapDAO = new LaptopDAO("root","06011999");
            if(lapDAO.addLaptop(laptop)){
                response.sendRedirect("Home.jsp?ok=0");
            }
            else{
                response.sendRedirect("Home.jsp?ok=99");
            }
        }
        else{
            response.sendRedirect("Home.jsp?ok=100");
        }
    }

    if(s.equals("Change Laptop Information")){ 
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        String check1 = (String)request.getParameter("idLaptop");
        int idLaptop = 0;
        int idProducer=0;
        int price=0;
        float size=0;
        int ram=0;
        if(!check1.equals("")){
            idLaptop = Integer.parseInt(request.getParameter("idLaptop"));
            Laptop laptop = new Laptop();           
            laptop = lapDAO.searchLaptop(idLaptop);
            if(laptop != null){
                String check = "";
                check = (String)request.getParameter("idProducer");
                if(!check.equals("")){
                    idProducer = Integer.parseInt(request.getParameter("idProducer"));
                    laptop.setIdProducer(idProducer);
                }           
                check = (String)request.getParameter("nameLaptop");
                if(!check.equals("")){
                    String nameLaptop = (String)request.getParameter("nameLaptop");
                    laptop.setName(nameLaptop);
                }
                check = (String)request.getParameter("type");
                if(!check.equals("")){
                    String type = (String)request.getParameter("type");
                    laptop.setType(type);
                }
                check = (String)request.getParameter("price");
                if(!check.equals("")){
                    price = Integer.parseInt(request.getParameter("price"));
                    laptop.setPrice(price);
                }
                check = (String)request.getParameter("size");
                if(!check.equals("")){
                    size = Float.parseFloat(request.getParameter("size"));
                    laptop.setSize(size);
                }
                check = (String)request.getParameter("cpu");
                if(!check.equals("")){
                    String cpu = (String)request.getParameter("cpu");
                    laptop.setCpu(cpu);
                }
                check = (String)request.getParameter("ram");
                if(!check.equals("")){
                    ram = Integer.parseInt(request.getParameter("ram"));
                    laptop.setRam(ram);
                }
                if(lapDAO.changeInformation(laptop)){
                    response.sendRedirect("Home.jsp?ok=1");
                }
                else{
                    response.sendRedirect("Home.jsp?ok=99");
                }
            }
            else{
                response.sendRedirect("Home.jsp?ok=3");
            }
        }
        else{
            response.sendRedirect("Home.jsp?ok=100");
        }
    }

    if(s.equals("Delete Laptop")){ 
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        String check = (String)request.getParameter("idLaptop");
        if(!check.equals("")){
            int idLaptop = Integer.parseInt(request.getParameter("idLaptop"));
            if(lapDAO.deleteLaptop(idLaptop)){
                response.sendRedirect("Home.jsp?ok=2");
            }
            else{
                response.sendRedirect("Home.jsp?ok=99");
            }
        }else{
            response.sendRedirect("Home.jsp?ok=100");
        }
    }

    if(s.equals("Search Laptop")){
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        String check = "";
        int count = 0;
        String arr[] = {"idLaptop", "nameLaptop", "nameProducer","price", "size", "rate"};
        for(int i=0; i<6; i++){
            String check1 = (String)request.getParameter(arr[i]);
            if(check1.equals(""))
                count++;
        }

        if(count == 6){
            response.sendRedirect("Home.jsp?ok=100");
        }
        else{
            if(count == 5){
                check = (String)request.getParameter("idLaptop");
                if(!check.equals("")){
                    int idLaptop = Integer.parseInt(request.getParameter("idLaptop"));
                    ArrayList<Laptop>list = new ArrayList<>();
                    list = lapDAO.searchLaptopByID(idLaptop);
                    session.setAttribute("list",list);
                    if(list.isEmpty()){
                        response.sendRedirect("Home.jsp?ok=3");
                    }else{
                        response.sendRedirect("Result.jsp");
                    }
                }
                else{
                    check = (String)request.getParameter("nameLaptop");
                    if(!check.equals("")){
                        String nameLaptop = (String)request.getParameter("nameLaptop");
                        ArrayList<Laptop> list = new ArrayList<>();
                        list = lapDAO.searchByName(nameLaptop);
                        session.setAttribute("list",list);
                        if(list.isEmpty()){
                            response.sendRedirect("Home.jsp?ok=3");
                        }else{
                            response.sendRedirect("Result.jsp");
                        }
                    }
                    else{
                        check = (String)request.getParameter("nameProducer");
                        if(!check.equals("")){
                            String nameProducer = (String)request.getParameter("nameProducer");
                            ArrayList<Laptop>list = new ArrayList<>();
                            list = lapDAO.searchByProducer(nameProducer);
                            session.setAttribute("list",list);
                            if(list.isEmpty()){
                            response.sendRedirect("Home.jsp?ok=3");
                            }else{
                            response.sendRedirect("Result.jsp");
                            }
                        }
                        else{
                            check = (String)request.getParameter("size");
                            if(!check.equals("")){
                                Float size = Float.parseFloat(request.getParameter("size"));
                                ArrayList<Laptop>list = new ArrayList<>();
                                list = lapDAO.searchBySize(size);
                                session.setAttribute("list",list);
                                if(list.isEmpty()){
                                response.sendRedirect("Home.jsp?ok=3");
                                }else{
                                response.sendRedirect("Result.jsp");
                                }
                            }
                            else{
                                check = (String)request.getParameter("price");
                                if(!check.equals("")){
                                    int price = Integer.parseInt(request.getParameter("price"));
                                    ArrayList<Laptop>list = new ArrayList<>();
                                    list = lapDAO.searchByPriceUnder(price);
                                    session.setAttribute("list",list);
                                    if(list.isEmpty()){
                                    response.sendRedirect("Home.jsp?ok=3");
                                    }
                                    else{
                                    response.sendRedirect("Result.jsp");
                                    }
                                }
                                else{
                                    response.sendRedirect("Home.jsp?ok=404");
                                }
                            }
                        }
                    }
                }
            }
            else{
                String s1 = (String)request.getParameter("size");
                String s2 = (String)request.getParameter("rate");
                if((count == 4) && (!s1.equals("")) && (!s2.equals(""))){
                    if((!s1.equals("")) && (!s2.equals(""))){
                        Float size = Float.parseFloat(request.getParameter("size"));
                        Float rate = Float.parseFloat(request.getParameter("rate"));
                        ArrayList<Laptop>list = new ArrayList<>();
                        list = lapDAO.searchBySizeAndRate(size,rate);
                        session.setAttribute("list",list);
                        if(list.isEmpty()){
                        response.sendRedirect("Home.jsp?ok=3");
                        }else{
                        response.sendRedirect("Result.jsp");
                        }
                    }
                    else{
                        response.sendRedirect("Home.jsp?ok=100");
                    }
                }
                else{
                    response.sendRedirect("Home.jsp?ok=404");
                }
            }          
        }
    }

    if(s.equals("Sort price ascending")){
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        ArrayList<Laptop>list = new ArrayList<>();
        list = lapDAO.sortPriceAscending();
        session.setAttribute("list",list);
        if(list.isEmpty()){
            response.sendRedirect("Home.jsp?ok=3");
        }
        else{
            response.sendRedirect("Result.jsp");
        }
    }

    if(s.equals("Sort price descending")){
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        ArrayList<Laptop>list = new ArrayList<>();
        list = lapDAO.sortPriceDescending();
        session.setAttribute("list",list);
        if(list.isEmpty()){
            response.sendRedirect("Home.jsp?ok=3");
        }
        else{
            response.sendRedirect("Result.jsp");
        }
    }

    if(s.equals("Add Producer")){ 
        String check = "";
        String nameProducer = "";
        float rate = 0;
        int count = 0;
        
        String arr[] = {"nameProducer","rate"};
        for(int i=0; i<2; i++){
            check = (String)request.getParameter(arr[i]);
            if(!check.equals(""))
                count++;
        }

        if(count == 2){
            nameProducer = (String)request.getParameter("nameProducer");
            rate = Float.parseFloat(request.getParameter("rate"));

            Producer producer = new Producer(nameProducer, rate);
            LaptopDAO lapDAO = new LaptopDAO("root","06011999");
            if(lapDAO.addProducer(producer)){
                response.sendRedirect("Home.jsp?ok=4");
            }
            else{
                response.sendRedirect("Home.jsp?ok=99");
            }
        }else{
            response.sendRedirect("Home.jsp?ok=100");
        }
    }

    if(s.equals("Change Producer Information")){ 
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        String check1 = "";
        int idProducer = 0;
        float rate = 0;
        String nameProducer = "";
        String check = (String)request.getParameter("idProducer");
        if(!check.equals("")){
            idProducer = Integer.parseInt(request.getParameter("idProducer"));
            Producer producer = new Producer();
            producer = lapDAO.searchProducer(idProducer);
            if(producer != null){
                check1 = (String)request.getParameter("nameProducer");
                if(!check1.equals("")){
                    nameProducer = (String)request.getParameter("nameProducer");
                    producer.setName(nameProducer);
                }
                check1 = (String)request.getParameter("rate");
                if(!check1.equals("")){
                    rate = Float.parseFloat(request.getParameter("rate"));
                    producer.setRate(rate);
                }
                if(lapDAO.changeProducerInformation(producer)){
                    response.sendRedirect("Home.jsp?ok=5");
                }
                else{
                    response.sendRedirect("Home.jsp?ok=99");
                }
            }
            else{
                response.sendRedirect("Home.jsp?ok=7");
            }
        }else{
            response.sendRedirect("Home.jsp?ok=100");
        }
    }

    if(s.equals("Delete Producer")){ 
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        String check = (String)request.getParameter("idProducer");
        if(!check.equals("")){
            int idProducer = Integer.parseInt(request.getParameter("idProducer"));
            if(lapDAO.deleteProducer(idProducer)){
                response.sendRedirect("Home.jsp?ok=6");
            }
            else{
                response.sendRedirect("Home.jsp?ok=99");
            }
        }
        else{
            response.sendRedirect("Home.jsp?ok=100");
        }
    }

    if(s.equals("Search Producer by ID")){
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        String check = "";
        check = (String)request.getParameter("idProducer");
        if(!check.equals("")){
            int idProducer = Integer.parseInt(request.getParameter("idProducer"));
            ArrayList<Producer>list = new ArrayList<>();
            list = lapDAO.searchProducerByID(idProducer);
            session.setAttribute("list",list);
            if(list.isEmpty()){
                response.sendRedirect("Home.jsp?ok=7");
            }else{
                response.sendRedirect("ProducerResult.jsp");
            }
        }else{
            response.sendRedirect("Home.jsp?ok=100");
        }
    }

    if(s.equals("List Producer")){
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        ArrayList<Producer>list = new ArrayList<>();
        list = lapDAO.listProducer();
        session.setAttribute("list",list);
        if(list.isEmpty()){
            response.sendRedirect("Home.jsp?ok=3");
        }
        else{
            response.sendRedirect("ProducerResult.jsp");
        }
    }

    if(s.equals("List Laptop by Producer")){
        LaptopDAO lapDAO = new LaptopDAO("root","06011999");
        ArrayList<Laptop>list = new ArrayList<>();
        list = lapDAO.listLaptop();
        session.setAttribute("list",list);
        if(list.isEmpty()){
            response.sendRedirect("Home.jsp?ok=3");
        }
        else{
            response.sendRedirect("Result.jsp");
        }
    }
%>