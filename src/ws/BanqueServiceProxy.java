package ws;

public class BanqueServiceProxy implements ws.BanqueService {
  private String _endpoint = null;
  private ws.BanqueService banqueService = null;
  
  public BanqueServiceProxy() {
    _initBanqueServiceProxy();
  }
  
  public BanqueServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBanqueServiceProxy();
  }
  
  private void _initBanqueServiceProxy() {
    try {
      banqueService = (new ws.BanqueWSLocator()).getBanqueServicePort();
      if (banqueService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)banqueService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)banqueService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (banqueService != null)
      ((javax.xml.rpc.Stub)banqueService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.BanqueService getBanqueService() {
    if (banqueService == null)
      _initBanqueServiceProxy();
    return banqueService;
  }
  
  public ws.Compte getCompte(int arg0) throws java.rmi.RemoteException{
    if (banqueService == null)
      _initBanqueServiceProxy();
    return banqueService.getCompte(arg0);
  }
  
  public double conversionEuroToDh(double montant) throws java.rmi.RemoteException{
    if (banqueService == null)
      _initBanqueServiceProxy();
    return banqueService.conversionEuroToDh(montant);
  }
  
  public ws.Compte[] listeCompte() throws java.rmi.RemoteException{
    if (banqueService == null)
      _initBanqueServiceProxy();
    return banqueService.listeCompte();
  }
  
  
}