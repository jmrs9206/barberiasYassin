"use client";

import { useEffect, useState } from "react";

interface SystemStatus {
  service: string;
  status: "ONLINE" | "OFFLINE" | "LOADING";
  details?: string;
}

export default function Home() {
  const [backendStatus, setBackendStatus] = useState<"ONLINE" | "OFFLINE" | "LOADING">("LOADING");
  const [dbStatus, setDbStatus] = useState<"ONLINE" | "OFFLINE" | "LOADING">("LOADING");

  useEffect(() => {
    // Fetch backend actuator health
    fetch("http://localhost:8080/actuator/health")
      .then((res) => {
        if (res.ok) {
          return res.json();
        }
        throw new Error("Backend offline");
      })
      .then((data) => {
        setBackendStatus("ONLINE");
        if (data.components?.db?.status === "UP" || data.status === "UP") {
          setDbStatus("ONLINE");
        } else {
          setDbStatus("OFFLINE");
        }
      })
      .catch(() => {
        setBackendStatus("OFFLINE");
        setDbStatus("OFFLINE");
      });
  }, []);

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 flex flex-col font-sans selection:bg-amber-500 selection:text-slate-900">
      {/* Header */}
      <header className="border-b border-slate-900 bg-slate-950/80 backdrop-blur sticky top-0 z-50">
        <div className="max-w-7xl mx-auto px-6 h-20 flex items-center justify-between">
          <div className="flex items-center gap-3">
            <div className="w-10 h-10 rounded-xl bg-gradient-to-tr from-amber-500 to-amber-600 flex items-center justify-center shadow-lg shadow-amber-500/20">
              <span className="font-extrabold text-slate-950 text-xl tracking-tighter">Y</span>
            </div>
            <div>
              <h1 className="font-black text-lg tracking-tight bg-gradient-to-r from-amber-400 to-amber-200 bg-clip-text text-transparent">
                BARBERÍA YASSIN
              </h1>
              <p className="text-[10px] text-slate-500 font-mono tracking-widest uppercase">Plano de Control</p>
            </div>
          </div>
          <div className="flex items-center gap-4">
            <span className="text-xs font-mono text-slate-500">v0.1.0-alpha</span>
            <div className="px-3 py-1 rounded-full border border-slate-800 bg-slate-900/50 text-[11px] font-mono text-slate-400 flex items-center gap-2">
              <span className="w-2 h-2 rounded-full bg-emerald-500 animate-pulse"></span>
              Fase 1: Fundacional
            </div>
          </div>
        </div>
      </header>

      {/* Main Content */}
      <main className="flex-1 max-w-7xl w-full mx-auto px-6 py-12 flex flex-col justify-center">
        <div className="grid lg:grid-cols-12 gap-12 items-center">
          {/* Left Column - Intro */}
          <div className="lg:col-span-7 flex flex-col gap-6">
            <div className="inline-flex items-center gap-2 px-3 py-1 rounded-full bg-amber-500/10 text-amber-400 text-xs font-semibold w-fit border border-amber-500/25">
              🚀 Entorno de Desarrollo Inicializado
            </div>
            <h2 className="text-4xl md:text-5xl lg:text-6xl font-black tracking-tight leading-tight text-white">
              Infraestructura lista. <br />
              <span className="bg-gradient-to-r from-amber-400 via-amber-300 to-amber-100 bg-clip-text text-transparent">
                Comenzando la construcción.
              </span>
            </h2>
            <p className="text-slate-400 text-base md:text-lg leading-relaxed max-w-xl">
              El monorrepo para la plataforma multiempresa ha completado su fundación técnica. 
              El backend modular y el frontend Next.js están comunicados y listos para desarrollar los slices de negocio.
            </p>
            <div className="flex flex-wrap gap-4 mt-4">
              <a
                href="http://localhost:8025"
                target="_blank"
                rel="noreferrer"
                className="px-6 h-12 rounded-xl bg-slate-900 border border-slate-800 text-slate-300 font-semibold text-sm hover:bg-slate-800/80 hover:text-white transition-all flex items-center gap-2"
              >
                📬 Abrir Mailpit
              </a>
              <a
                href="/api-docs"
                className="px-6 h-12 rounded-xl bg-slate-900/50 border border-slate-900 text-slate-500 font-semibold text-sm cursor-not-allowed flex items-center gap-2"
              >
                📖 Swagger (Fase 2)
              </a>
            </div>
          </div>

          {/* Right Column - Status Panel */}
          <div className="lg:col-span-5">
            <div className="p-8 rounded-3xl bg-slate-900/40 border border-slate-900 backdrop-blur-xl relative overflow-hidden">
              <div className="absolute top-0 right-0 w-32 h-32 bg-amber-500/5 rounded-full blur-3xl"></div>
              
              <h3 className="text-white font-extrabold text-lg mb-6 flex items-center gap-2">
                🟢 Estado de los Servicios Locales
              </h3>

              <div className="flex flex-col gap-4">
                {/* Frontend Status */}
                <div className="p-4 rounded-2xl bg-slate-950/50 border border-slate-900 flex items-center justify-between">
                  <div className="flex items-center gap-3">
                    <div className="w-8 h-8 rounded-lg bg-blue-500/10 text-blue-400 flex items-center justify-center font-bold text-xs">
                      WEB
                    </div>
                    <div>
                      <p className="text-xs font-bold text-white">Next.js Frontend</p>
                      <p className="text-[10px] text-slate-500 font-mono">Port 3000</p>
                    </div>
                  </div>
                  <span className="px-2.5 py-1 rounded-md bg-emerald-500/10 text-emerald-400 font-mono font-bold text-[10px] tracking-wider border border-emerald-500/20">
                    ONLINE
                  </span>
                </div>

                {/* Backend Status */}
                <div className="p-4 rounded-2xl bg-slate-950/50 border border-slate-900 flex items-center justify-between">
                  <div className="flex items-center gap-3">
                    <div className="w-8 h-8 rounded-lg bg-green-500/10 text-green-400 flex items-center justify-center font-bold text-xs">
                      API
                    </div>
                    <div>
                      <p className="text-xs font-bold text-white">Spring Boot API</p>
                      <p className="text-[10px] text-slate-500 font-mono">Port 8080</p>
                    </div>
                  </div>
                  {backendStatus === "ONLINE" ? (
                    <span className="px-2.5 py-1 rounded-md bg-emerald-500/10 text-emerald-400 font-mono font-bold text-[10px] tracking-wider border border-emerald-500/20">
                      ONLINE
                    </span>
                  ) : backendStatus === "OFFLINE" ? (
                    <span className="px-2.5 py-1 rounded-md bg-rose-500/10 text-rose-400 font-mono font-bold text-[10px] tracking-wider border border-rose-500/20">
                      OFFLINE
                    </span>
                  ) : (
                    <span className="px-2.5 py-1 rounded-md bg-amber-500/10 text-amber-400 font-mono font-bold text-[10px] tracking-wider border border-amber-500/20 animate-pulse">
                      LOADING
                    </span>
                  )}
                </div>

                {/* Database Status */}
                <div className="p-4 rounded-2xl bg-slate-950/50 border border-slate-900 flex items-center justify-between">
                  <div className="flex items-center gap-3">
                    <div className="w-8 h-8 rounded-lg bg-indigo-500/10 text-indigo-400 flex items-center justify-center font-bold text-xs">
                      DB
                    </div>
                    <div>
                      <p className="text-xs font-bold text-white">PostgreSQL 16</p>
                      <p className="text-[10px] text-slate-500 font-mono">Port 5432</p>
                    </div>
                  </div>
                  {dbStatus === "ONLINE" ? (
                    <span className="px-2.5 py-1 rounded-md bg-emerald-500/10 text-emerald-400 font-mono font-bold text-[10px] tracking-wider border border-emerald-500/20">
                      ONLINE
                    </span>
                  ) : dbStatus === "OFFLINE" ? (
                    <span className="px-2.5 py-1 rounded-md bg-rose-500/10 text-rose-400 font-mono font-bold text-[10px] tracking-wider border border-rose-500/20">
                      OFFLINE
                    </span>
                  ) : (
                    <span className="px-2.5 py-1 rounded-md bg-amber-500/10 text-amber-400 font-mono font-bold text-[10px] tracking-wider border border-amber-500/20 animate-pulse">
                      LOADING
                    </span>
                  )}
                </div>
              </div>

              {/* Instructions */}
              <div className="mt-6 pt-6 border-t border-slate-950/50 text-[11px] text-slate-500 font-mono leading-relaxed">
                <p>💡 Usa <code className="text-slate-400 bg-slate-950 px-1 py-0.5 rounded">make dev</code> para levantar el backend y frontend en paralelo con la base de datos local en docker compose.</p>
              </div>
            </div>
          </div>
        </div>
      </main>

      {/* Footer */}
      <footer className="border-t border-slate-900 bg-slate-950 py-8">
        <div className="max-w-7xl mx-auto px-6 flex flex-col md:flex-row items-center justify-between gap-4 text-xs font-mono text-slate-600">
          <p>© 2026 Barbería Yassin. Todos los derechos reservados.</p>
          <div className="flex gap-6">
            <a href="https://github.com/jmrs9206/barberiasYassin" target="_blank" rel="noreferrer" className="hover:text-slate-400 transition-colors">GitHub</a>
            <span>•</span>
            <span className="text-slate-500">Built with Antigravity AI</span>
          </div>
        </div>
      </footer>
    </div>
  );
}
